package com.javalenciab90.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.javalenciab90.auth.navigation.buildAuthGraph
import com.javalenciab90.auth.navigation.AuthRoutes
import com.javalenciab90.home.navigation.buildHomeGraph


@Composable
fun NavigatorAppHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AuthRoutes.Splash
    ) {
        buildAppGraph(navController)
    }
}

fun NavGraphBuilder.buildAppGraph(navController: NavController) {
    buildAuthGraph(navController)
    buildHomeGraph(navController)
    // Add more feature graphs here
}

