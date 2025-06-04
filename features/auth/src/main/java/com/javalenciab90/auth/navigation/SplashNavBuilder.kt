package com.javalenciab90.auth.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.auth.ui.components.splash.SplashContent
import com.javalenciab90.auth.ui.components.splash.SplashScreen
import com.javalenciab90.auth.ui.viewmodel.splash.SplashContract
import com.javalenciab90.auth.ui.viewmodel.splash.SplashViewModel
import com.javalenciab90.navigation.routes.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

private const val MIN_SPLASH_DURATION_MS = 3000L

fun NavGraphBuilder.buildSplashScreen(
    navController: NavController
) {
    composable<Routes.Splash> {

        val viewModel = hiltViewModel<SplashViewModel>()

        LaunchedEffect(Unit) {
            val splashTimerJob = launch {
                delay(MIN_SPLASH_DURATION_MS)
            }
            val effect = viewModel.sideEffect.first()
            splashTimerJob.join()

            when (effect) {
                is SplashContract.Effect.InitLoginScreen -> navController.initLogin()
                is SplashContract.Effect.InitHomeScreen -> navController.initHome()
            }
        }

        SplashScreen {
            SplashContent()
        }
    }
}

fun NavController.initLogin() {
    navigate(Routes.Login) {
        popUpTo(Routes.Splash) {
            inclusive = true
        }
    }
}

fun NavController.initHome() {
    //navigate(Routes.Home)
}