package com.javalenciab90.deeplinks.routes

/***
 * Here
 * Represents a deep link that can be used to navigate to
 * a specific activity (feature) in the application.
 *
 * Each deep link is defined by a unique route,
 * which is a string that identifies the screen to navigate to.
 *
 */

interface Deeplink {
    val route: String

    data object Authentication : Deeplink {
        override val route = "/authentication"
    }

    data object Home : Deeplink {
        override val route = "/home"
    }

    // Add as many routes as Activities(feature) you want to support
}