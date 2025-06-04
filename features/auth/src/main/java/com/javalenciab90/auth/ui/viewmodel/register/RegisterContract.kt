package com.javalenciab90.auth.ui.viewmodel.register

class RegisterContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val confirmPassword: String = ""
    )

    sealed interface Effect {
        data object GoToLogin : Effect
    }

    sealed interface Intent {
        data class UpdateEmail(val email: String) : Intent
        data class UpdatePassword(val password: String) : Intent
        data class UpdateConfirmPassword(val confirmPassword: String) : Intent
        data object RegisterAction : Intent
        data object LoginAction : Intent
    }
}

sealed interface Status {
    data object Loading : Status
    data object Success : Status
    data object Error : Status
}