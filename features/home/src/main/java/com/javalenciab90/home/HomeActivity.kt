package com.javalenciab90.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import com.javalenciab90.home.navigation.NavigatorHomeHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssemblyBoardAppTheme {
                NavigatorHomeHost()
            }
        }
    }
}