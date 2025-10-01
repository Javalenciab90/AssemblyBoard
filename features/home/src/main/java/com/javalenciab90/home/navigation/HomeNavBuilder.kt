package com.javalenciab90.home.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.base.effect.ObserveEffects
import com.javalenciab90.base.providers.AppProvider
import com.javalenciab90.deeplinks.routes.Deeplink
import com.javalenciab90.design_system.components.dialog.ConfirmationDialog
import com.javalenciab90.home.R
import com.javalenciab90.design_system.R as DesignSystemR
import com.javalenciab90.home.ui.components.HomeContent
import com.javalenciab90.home.ui.components.HomeScreen
import com.javalenciab90.home.ui.viewmodel.HomeContract
import com.javalenciab90.home.ui.viewmodel.HomeViewModel

fun NavGraphBuilder.buildHomeScreen(
    navController: NavController
) {
    composable<HomeRoutes.Home> {

        val viewModel = hiltViewModel<HomeViewModel>()
        val uiState = viewModel.uiState.collectAsStateWithLifecycle()

        ObserveEffects(flow = viewModel.sideEffect) { effect ->
            when (effect) {
                HomeContract.Effect.SignOut -> {
                    navController.navigateDeeplinkToLogin()
                }
            }
        }

        HomeScreen(
            onProfileClick = {
                //navController.navigate(HomeRoutes.Profile)
            },
            onLogoutClick = {
                viewModel.handleIntent(HomeContract.Intent.SignOut)
            },
            pageContent = { paddingValues ->
                HomeContent(
                    modifier = Modifier.padding(paddingValues),
                    uiState = uiState.value,
                    onHandleIntent = {
                        viewModel.handleIntent(it)
                    }
                )
            }
        )

        ConfirmationDialog(
            isVisible = uiState.value.showConfirmSignOutDialog,
            title = R.string.dialog_sign_out_title,
            message = R.string.dialog_sign_out_message,
            icon = DesignSystemR.drawable.ic_question_mark,
            confirmButtonText = R.string.dialog_sign_out_confirm,
            cancelButtonText = DesignSystemR.string.dialog_cancel_button_default,
            onConfirm = {
                viewModel.handleIntent(HomeContract.Intent.ConfirmSignOut)
            }, onDismiss = {
                viewModel.handleIntent(HomeContract.Intent.CancelSignOut)
            }
        )
    }
}

fun NavController.navigateDeeplinkToLogin() {
    (context.applicationContext as AppProvider)
        .deeplinkHandler
        .process(context, Deeplink.Authentication.route)
}

