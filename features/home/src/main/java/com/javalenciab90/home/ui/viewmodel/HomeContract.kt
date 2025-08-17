package com.javalenciab90.home.ui.viewmodel

class HomeContract {
    data class State(
        val status: Status
    )

    sealed interface Effect {
        data object SignOut: Effect
    }

    sealed interface Intent {
        data object SignOut: Intent
    }
}

sealed interface Status {
    data class Success(
        val currentUser: String = ""
    ) : Status
    data object Loading : Status
    data object Error : Status
}