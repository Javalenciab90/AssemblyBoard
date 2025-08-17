package com.javalenciab90.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigatorHomeHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HomeRoutes.Home
    ) {
        buildHomeGraph(navController)
    }
}
fun NavGraphBuilder.buildHomeGraph(navController: NavController) {
    buildHomeScreen(navController)
}