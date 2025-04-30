package com.javalenciab90.auth.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.javalenciab90.auth.ui.components.resetpassword.ResetPasswordContent
import com.javalenciab90.auth.ui.components.resetpassword.ResetPasswordScreen
import com.javalenciab90.navigation.routes.Routes

fun NavGraphBuilder.buildResetScreen(
    navController: NavController
) {
    composable<Routes.Reset> {
        ResetPasswordScreen(
            onHandleIntent = Unit,
            onBack = { navController.navigateBack() }
        ) { paddingValues ->
            ResetPasswordContent(
                modifier = Modifier.padding(paddingValues)
            ) {
                // Send Email
            }
        }
    }
}

fun NavController.navigateBack() {
    popBackStack()
}