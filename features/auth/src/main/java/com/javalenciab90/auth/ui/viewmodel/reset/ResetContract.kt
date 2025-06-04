package com.javalenciab90.auth.ui.viewmodel.reset

class ResetContract {

    data class State(
        val email: String = ""
    )

    sealed interface Effect {

    }

    sealed interface Intent {
        data class UpdateEmail(val email: String) : Intent
        data object SendResetEmailAction : Intent
    }
}