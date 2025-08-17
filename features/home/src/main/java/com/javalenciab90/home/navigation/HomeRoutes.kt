package com.javalenciab90.home.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface HomeRoutes {

    @Serializable
    data object Home : HomeRoutes
}
