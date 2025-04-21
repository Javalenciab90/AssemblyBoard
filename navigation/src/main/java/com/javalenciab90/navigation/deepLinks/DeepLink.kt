package com.javalenciab90.navigation.deepLinks

interface Deeplink {
    val route: String

    data object Home : Deeplink {
        override val route = "/home"
    }
}