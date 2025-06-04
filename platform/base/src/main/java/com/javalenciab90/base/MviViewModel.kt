package com.javalenciab90.base

import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class MviViewModel<STATE : Any, EFFECT : Any, INTENT : Any>(
    private val context: CoroutineContextProvider
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    @CallSuper
    open fun handleError(exception: Throwable) {
        Log.e("ERROR", exception.toString())
    }

    private val initialState by lazy { setInitialState() }

    abstract fun setInitialState(): STATE

    val _mutableUiState = MutableStateFlow(initialState)
    val uiState = _mutableUiState.asStateFlow()
    val currentUiState: STATE get() = uiState.value

    private val _effect: Channel<EFFECT> = Channel()
    val sideEffect = _effect.receiveAsFlow()

    protected fun postSideEffect(effectValue: EFFECT) {
        launchInMain {
            _effect.send(effectValue)
        }
    }

    open fun handleIntent(intent: INTENT) {}

    private val mutex: Mutex = Mutex()

    fun updateNow(reducer: (STATE) -> STATE) {
        launchInImmediate {
            mutex.withLock {
                _mutableUiState.update(reducer)
            }
        }
    }

    protected fun launchInImmediate(
        onStart: (suspend () -> Unit)? = null,
        onFinish: (suspend () -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(block, context.immediateContext, onStart, onFinish)


    protected fun launchInMain(
        onStart: (suspend () -> Unit)? = null,
        onFinish: (suspend () -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(block, context.mainContext, onStart, onFinish)

    protected fun launchInBackground(
        onStart: (suspend () -> Unit)? = null,
        onFinish: (suspend () -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(block, context.backgroundContext, onStart, onFinish)

    private fun launch(
        block: suspend CoroutineScope.() -> Unit,
        coroutineContext: CoroutineContext,
        onStart: (suspend () -> Unit)? = null,
        onFinish: (suspend () -> Unit)? = null
    ) = viewModelScope.launch(handler) {
        withContext(coroutineContext) {
            onStart?.invoke()
            block()
            onFinish?.invoke()
        }
    }

}