package com.javalenciab90.auth.ui.components.splash

import androidx.compose.runtime.Composable

@Composable
fun SplashScreen(
    onHandleIntent: Unit,
    content: @Composable () -> Unit
) {
    content()
}