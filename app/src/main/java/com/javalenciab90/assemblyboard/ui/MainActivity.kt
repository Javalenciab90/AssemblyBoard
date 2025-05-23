package com.javalenciab90.assemblyboard.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.javalenciab90.assemblyboard.navigator.NavigatorApp
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssemblyBoardAppTheme {
                NavigatorApp()
            }
        }
    }
}
