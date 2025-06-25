package com.javalenciab90.auth.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.auth.ui.components.login.LoginContent
import com.javalenciab90.auth.ui.components.login.LoginScreen
import com.javalenciab90.auth.ui.viewmodel.login.LoginContract
import com.javalenciab90.auth.ui.viewmodel.login.LoginViewModel
import com.javalenciab90.base.effect.ObserveEffects
import com.javalenciab90.navigation.routes.Routes

fun NavGraphBuilder.buildLoginScreen(
    navController: NavController
) {
    composable<Routes.Login> {

        val viewModel = hiltViewModel<LoginViewModel>()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle()

        ObserveEffects(flow = viewModel.sideEffect) { effect ->
            when (effect) {
                LoginContract.Effect.GoToRegister -> {
                    navController.navigateToRegister()
                }
                LoginContract.Effect.GoToResetPassword -> {
                    navController.navigateToReset()
                }
            }
        }

        LoginScreen { paddingValues ->
            LoginContent(
                modifier = Modifier.padding(paddingValues),
                uiState = uiState.value,
                onHandleIntent = {
                    viewModel.handleIntent(it)
                }
            )
        }
    }
}

fun NavController.navigateToRegister() {
    navigate(Routes.Register)
}

fun NavController.navigateToReset() {
    navigate(Routes.Reset)
}

fun navigateToHome() {
    // Navigate to home screen with DeepLinks
    // navigate(Routes.Home)
}
