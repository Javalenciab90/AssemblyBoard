package com.javalenciab90.auth.ui.viewmodel.splash

class SplashContract {
    data class State(
        val status: Status
    )

    sealed interface Effect {
        data object InitLoginScreen : Effect
        data object InitHomeScreen : Effect
    }

    sealed interface Intent {
       data object CheckUserIsLoggedIn : Intent
    }
}

sealed interface Status {
    data class Success(val isLoggedIn: Boolean) : Status
    data object Error : Status
}