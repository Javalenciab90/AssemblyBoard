package com.javalenciab90.auth.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.auth.ui.components.resetpassword.ResetPasswordContent
import com.javalenciab90.auth.ui.components.resetpassword.ResetPasswordScreen
import com.javalenciab90.auth.ui.viewmodel.reset.ResetViewModel
import com.javalenciab90.base.effect.ObserveEffects

fun NavGraphBuilder.buildResetScreen(
    navController: NavController
) {
    composable<AuthRoutes.Reset> {

        val viewModel = hiltViewModel<ResetViewModel>()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle()

        ObserveEffects(flow = viewModel.sideEffect) { effect ->

        }

        ResetPasswordScreen(
            onBack = { navController.navigateBack() }
        ) { paddingValues ->
            ResetPasswordContent(
                modifier = Modifier.padding(paddingValues),
                uiState = uiState.value,
                onHandleIntent = {
                    viewModel.handleIntent(it)
                }
            )
        }
    }
}

fun NavController.navigateBack() {
    popBackStack()
}