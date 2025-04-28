package com.javalenciab90.assemblyboard.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.javalenciab90.auth.navigation.buildLoginScreen
import com.javalenciab90.auth.navigation.buildRegisterScreen
import com.javalenciab90.navigation.routes.Routes

@Composable
fun NavigatorApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController, startDestination = Routes.Login
    ) {
        buildLoginScreen(navController)
        buildRegisterScreen(navController)
    }
}