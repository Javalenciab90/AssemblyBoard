package com.javalenciab90.auth.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.auth.ui.components.register.RegisterContent
import com.javalenciab90.auth.ui.components.register.RegisterScreen
import com.javalenciab90.auth.ui.viewmodel.register.RegisterContract
import com.javalenciab90.auth.ui.viewmodel.register.RegisterViewModel
import com.javalenciab90.base.effect.ObserveEffects

fun NavGraphBuilder.buildRegisterScreen(
    navController: NavController
) {
    composable<AuthRoutes.Register> {

        val viewModel = hiltViewModel<RegisterViewModel>()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle()
        val context = LocalContext.current

        ObserveEffects(flow = viewModel.sideEffect) { effect ->
            when (effect) {
                RegisterContract.Effect.GoToLogin -> {
                    navController.navigateToLogin()
                }
                RegisterContract.Effect.GoToHome -> {
                    navigateDeeplinkToHome(context = context)
                }
            }
        }

        RegisterScreen {
            RegisterScreen { paddingValues ->
                RegisterContent(
                    modifier = Modifier.padding(paddingValues),
                    uiState = uiState.value,
                    onHandleIntent = {
                        viewModel.handleIntent(it)
                    }
                )
            }
        }
    }
}

fun NavController.navigateToLogin() {
    navigate(AuthRoutes.Login)
}