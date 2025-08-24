package com.javalenciab90.home.ui.viewmodel

import com.javalenciab90.domain.models.UserProfile

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
        val currentUserProfile: UserProfile = UserProfile(
            uid = "",
            displayName = "",
            email = "",
            photoUrl = "",
            phoneNumber = ""
        )
    ) : Status
    data object Loading : Status
    data object Error : Status
}