package com.javalenciab90.auth.ui.viewmodel.splash

import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.usecases.IsLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val isLoggedInUseCase: IsLoggedInUseCase,
    coroutineContextProvider: CoroutineContextProvider
) : MviViewModel<SplashContract.State, SplashContract.Effect, SplashContract.Intent>(coroutineContextProvider) {

    override fun handleIntent(intent: SplashContract.Intent) {
        when (intent) {
            SplashContract.Intent.CheckUserIsLoggedIn -> checkUserIsLoggedIn()
        }
    }

    private fun checkUserIsLoggedIn() {
        launchInBackground {
            isLoggedInUseCase().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        if (result.data) {
                            postSideEffect(SplashContract.Effect.InitHomeScreen)
                        } else {
                            postSideEffect(SplashContract.Effect.InitLoginScreen)
                        }
                    }
                    is Resource.Error -> {
                        // TODO: Handle error
                    }
                }
            }
        }
    }

    override fun setInitialState(): SplashContract.State = SplashContract.State(status = Status.Success(false))
}


