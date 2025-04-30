package com.javalenciab90.auth.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.auth.ui.components.login.LoginContent
import com.javalenciab90.auth.ui.components.login.LoginScreen
import com.javalenciab90.navigation.routes.Routes

fun NavGraphBuilder.buildLoginScreen(
    navController: NavController
) {
    composable<Routes.Login> {
        LoginScreen(
            onHandleIntent = Unit
        ) { paddingValues ->
            LoginContent(
                modifier = Modifier.padding(paddingValues),
                onForgotPassword = {
                    navController.navigateToReset()
                },
                onRegisterClick = {
                    navController.navigateToRegister()
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
