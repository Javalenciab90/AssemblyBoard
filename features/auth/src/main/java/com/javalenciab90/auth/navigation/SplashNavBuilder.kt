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
import com.javalenciab90.base.effect.ObserveEffects
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val MIN_SPLASH_DURATION_MS = 3000L

fun NavGraphBuilder.buildSplashScreen(
    navController: NavController
) {
    composable<AuthRoutes.Splash> {

        val viewModel = hiltViewModel<SplashViewModel>()

        LaunchedEffect(Unit) {
            val splashTimerJob = launch {
                delay(MIN_SPLASH_DURATION_MS)
                viewModel.handleIntent(SplashContract.Intent.CheckUserIsLoggedIn)
            }
            splashTimerJob.join()
        }

        ObserveEffects(flow = viewModel.sideEffect) { effect ->
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
    navigate(AuthRoutes.Login) {
        popUpTo(AuthRoutes.Splash) {
            inclusive = true
        }
    }
}

fun NavController.initHome() {
    // Todo: Navigate to HomeActivity through DeepLinks
}