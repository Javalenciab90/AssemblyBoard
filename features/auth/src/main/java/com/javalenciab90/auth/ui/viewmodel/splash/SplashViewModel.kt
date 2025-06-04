package com.javalenciab90.auth.ui.viewmodel.splash

import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import com.javalenciab90.domain.Result
import com.javalenciab90.domain.usecases.IsLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isLoggedInUseCase: IsLoggedInUseCase,
    context: CoroutineContextProvider
) : MviViewModel<SplashContract.State, SplashContract.Effect, SplashContract.Intent>(context) {

    init {
        checkUserIsLoggedIn()
    }

    private fun checkUserIsLoggedIn() {
        launchInBackground {
            isLoggedInUseCase().collect { result ->
                when (result) {
                    is Result.Success -> {
                        if (result.data) {
                            postSideEffect(SplashContract.Effect.InitHomeScreen)
                        } else {
                            postSideEffect(SplashContract.Effect.InitLoginScreen)
                        }
                    }
                    is Result.Error -> {
                        // TODO: Handle error
                    }
                }
            }
        }
    }

    override fun setInitialState(): SplashContract.State = SplashContract.State(status = Status.Success(false))
}


