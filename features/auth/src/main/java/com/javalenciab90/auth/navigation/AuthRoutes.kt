package com.javalenciab90.auth.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AuthRoutes {

    @Serializable
    data object Splash : AuthRoutes

    @Serializable
    data object Login : AuthRoutes

    @Serializable
    data object Register : AuthRoutes

    @Serializable
    data object Reset : AuthRoutes
}