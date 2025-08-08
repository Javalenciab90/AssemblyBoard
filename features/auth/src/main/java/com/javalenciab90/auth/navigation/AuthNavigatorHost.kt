package com.javalenciab90.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

fun NavGraphBuilder.buildAuthGraph(navController: NavController) {
    buildSplashScreen(navController)
    buildLoginScreen(navController)
    buildRegisterScreen(navController)
    buildResetScreen(navController)
}