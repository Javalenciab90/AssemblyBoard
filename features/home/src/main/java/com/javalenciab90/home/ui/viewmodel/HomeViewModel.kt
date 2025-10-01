package com.javalenciab90.home.ui.viewmodel

import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.usecases.GetCurrentUserUseCase
import com.javalenciab90.domain.usecases.SignOutUseCase
import com.javalenciab90.home.domain.usecases.CreateUserDocumentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val createUserDocumentUseCase: CreateUserDocumentUseCase,
    private val signOutUseCase: SignOutUseCase,
    coroutineContextProvider: CoroutineContextProvider
) : MviViewModel<HomeContract.State, HomeContract.Effect, HomeContract.Intent>(coroutineContextProvider) {

    init {
        getCurrentUser()
    }

    override fun handleIntent(intent: HomeContract.Intent) {
        when (intent) {
            HomeContract.Intent.SignOut -> {
                showConfirmSignOutDialog()
            }

            HomeContract.Intent.ConfirmSignOut -> {
                hideConfirmSignOutDialog()
                signOut()
            }
            HomeContract.Intent.CancelSignOut -> {
                hideConfirmSignOutDialog()
            }
        }
    }

    private fun getCurrentUser() {
        launchInBackground {
            getCurrentUserUseCase().collect { currentUserResult ->
                when (currentUserResult) {
                    is Resource.Success -> {
                        createUserDocumentUseCase.invoke(currentUserResult.data).collect {
                            updateNow {
                                it.copy(status = Status.Success(currentUserResult.data))
                            }
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

    private fun showConfirmSignOutDialog() {
        updateNow {
            it.copy(showConfirmSignOutDialog = true)
        }
    }

    private fun hideConfirmSignOutDialog() {
        updateNow {
            it.copy(showConfirmSignOutDialog = false)
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