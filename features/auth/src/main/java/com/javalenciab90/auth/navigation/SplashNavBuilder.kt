package com.javalenciab90.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.auth.ui.components.splash.SplashContent
import com.javalenciab90.auth.ui.components.splash.SplashScreen
import com.javalenciab90.navigation.routes.Routes

fun NavGraphBuilder.buildSplashScreen(
    navController: NavController
) {
    composable<Routes.Splash> {
        SplashScreen(
            onHandleIntent = Unit
        ) {
            SplashContent { navController.initLogin() }
        }
    }
}

fun NavController.initLogin() {
    navigate(Routes.Login)
}

fun NavController.initHome() {
    //navigate(Routes.Home)
}