package com.javalenciab90.auth.ui.components.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onHandleIntent: Unit,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.wrapContentHeight(),
                title = { Text("") },
            )
        },
        content = {
            pageContent(it)
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun WeatherScreenPreview() {
    AssemblyBoardAppTheme {
        LoginScreen(
            onHandleIntent = Unit
        ) { paddingValues ->
            LoginContent(
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}