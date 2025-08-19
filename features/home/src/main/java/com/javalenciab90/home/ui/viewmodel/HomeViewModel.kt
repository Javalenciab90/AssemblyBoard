package com.javalenciab90.home.ui.viewmodel

import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.usecases.GetCurrentUserUseCase
import com.javalenciab90.domain.usecases.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val signOutUseCase: SignOutUseCase,
    coroutineContextProvider: CoroutineContextProvider
) : MviViewModel<HomeContract.State, HomeContract.Effect, HomeContract.Intent>(coroutineContextProvider) {

    init {
        getCurrentUser()
    }

    override fun handleIntent(intent: HomeContract.Intent) {
        when (intent) {
            HomeContract.Intent.SignOut -> {
                signOut()
            }
        }
    }

    private fun getCurrentUser() {
        launchInBackground {
            getCurrentUserUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        updateNow {
                            it.copy(status = Status.Success(currentUser = result.data))
                        }
                    }
                    is Resource.Error -> {
                        updateNow {
                            it.copy(status = Status.Error)
                        }
                    }
                }
            }
        }
    }

    private fun signOut() {
        launchInBackground {
            signOutUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        postSideEffect(HomeContract.Effect.SignOut)
                    }
                    is Resource.Error -> {
                        // TODO: Handle error
                        postSideEffect(HomeContract.Effect.SignOut)
                    }
                }
            }
        }
    }

    override fun setInitialState(): HomeContract.State = HomeContract.State(status = Status.Loading)
}