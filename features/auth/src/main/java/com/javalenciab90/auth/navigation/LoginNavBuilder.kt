package com.javalenciab90.auth.navigation

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.javalenciab90.base.providers.AppProvider
import com.javalenciab90.deeplinks.routes.Deeplink

fun NavGraphBuilder.buildLoginScreen(
    navController: NavController
) {
    composable<AuthRoutes.Login> {

        val context = LocalContext.current
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
                LoginContract.Effect.GoToHome -> {
                    navigateDeeplinkToHome(context = context)
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
    navigate(AuthRoutes.Register)
}

fun NavController.navigateToReset() {
    navigate(AuthRoutes.Reset)
}

fun navigateDeeplinkToHome(context: Context) {
    (context.applicationContext as AppProvider)
        .deeplinkHandler
        .process(context, Deeplink.Home.route)
}
