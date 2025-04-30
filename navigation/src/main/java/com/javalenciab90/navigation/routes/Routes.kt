package com.javalenciab90.navigation.routes

import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes {

    @Serializable
    data object Login : Routes

    @Serializable
    data object Register : Routes

    @Serializable
    data object Reset : Routes
}