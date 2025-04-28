package com.javalenciab90.auth.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.auth.ui.components.register.RegisterContent
import com.javalenciab90.auth.ui.components.register.RegisterScreen
import com.javalenciab90.navigation.routes.Routes

fun NavGraphBuilder.buildRegisterScreen(
    navController: NavController
) {
    composable<Routes.Register> {
        RegisterScreen {
            RegisterScreen { paddingValues ->
                RegisterContent(
                    modifier = Modifier.padding(paddingValues),
                    onRegisterClick = {

                    },
                    onLoginClick = {
                        navController.navigateToLogin()
                    }
                )
            }
        }
    }
}

fun NavController.navigateToLogin() {
    navigate(Routes.Login)
}