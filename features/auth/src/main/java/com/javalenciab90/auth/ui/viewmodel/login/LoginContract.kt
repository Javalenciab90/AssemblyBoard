package com.javalenciab90.auth.ui.viewmodel.login

class LoginContract {

    data class State(
        val email: String = "",
        val password: String = ""
    )

    sealed interface Effect {
        data object GoToRegister : Effect
        data object GoToResetPassword : Effect
    }

    sealed interface Intent {
        data class UpdateEmail(val email: String) : Intent
        data class UpdatePassword(val password: String) : Intent
        data object RegisterAction : Intent
        data object LoginAction : Intent
        data object ForgotPasswordAction : Intent
    }
}