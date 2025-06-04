package com.javalenciab90.auth.ui.viewmodel.register

import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    context: CoroutineContextProvider
): MviViewModel<RegisterContract.State, RegisterContract.Effect, RegisterContract.Intent>(context) {

    override fun setInitialState(): RegisterContract.State = RegisterContract.State()

    override fun handleIntent(intent: RegisterContract.Intent) {
        when (intent) {
            is RegisterContract.Intent.UpdateEmail -> {
                updateNow {
                    it.copy(email = intent.email)
                }
            }
            is RegisterContract.Intent.UpdatePassword -> {
                updateNow {
                    it.copy(password = intent.password)
                }
            }
            is RegisterContract.Intent.UpdateConfirmPassword -> {
                updateNow {
                    it.copy(confirmPassword = intent.confirmPassword)
                }
            }
            RegisterContract.Intent.RegisterAction -> {
                //register()
            }
            RegisterContract.Intent.LoginAction -> {
                postSideEffect(RegisterContract.Effect.GoToLogin)
            }
        }
    }
}