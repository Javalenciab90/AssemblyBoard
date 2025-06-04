package com.javalenciab90.auth.ui.viewmodel.login

import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    context: CoroutineContextProvider
) : MviViewModel<LoginContract.State, LoginContract.Effect, LoginContract.Intent>(context) {

    override fun setInitialState(): LoginContract.State = LoginContract.State()

    override fun handleIntent(intent: LoginContract.Intent) {
        when (intent) {
            is LoginContract.Intent.UpdateEmail -> {
                updateNow {
                    it.copy(email = intent.email)
                }
            }
            is LoginContract.Intent.UpdatePassword -> {
                updateNow {
                    it.copy(password = intent.password)
                }
            }
            LoginContract.Intent.LoginAction -> {
                //login()
            }
            LoginContract.Intent.RegisterAction -> {
                postSideEffect(LoginContract.Effect.GoToRegister)
            }
            LoginContract.Intent.ForgotPasswordAction -> {
                postSideEffect(LoginContract.Effect.GoToResetPassword)
            }
        }
    }
}