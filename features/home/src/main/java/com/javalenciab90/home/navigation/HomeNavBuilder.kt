package com.javalenciab90.home.navigation

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.base.effect.ObserveEffects
import com.javalenciab90.base.providers.AppProvider
import com.javalenciab90.deeplinks.routes.Deeplink
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

        HomeScreen { paddingValues ->
            HomeContent(
                modifier = Modifier.padding(paddingValues),
                uiState = uiState.value,
                onHandleIntent = {
                    viewModel.handleIntent(it)
                }
            )
        }

    }
}

fun NavController.navigateDeeplinkToLogin() {
    Log.d("TAG", "navigateDeeplinkToLogin")
    (context.applicationContext as AppProvider)
        .deeplinkHandler
        .process(context, Deeplink.Authentication.route)
}

