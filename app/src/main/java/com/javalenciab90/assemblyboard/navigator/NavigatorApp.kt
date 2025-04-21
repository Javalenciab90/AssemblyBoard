package com.javalenciab90.assemblyboard.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javalenciab90.navigation.routes.Routes

@Composable
fun NavigatorApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login
    ) {
        composable<Routes.Login> {

        }
    }
}