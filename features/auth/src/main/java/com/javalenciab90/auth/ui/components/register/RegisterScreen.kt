package com.javalenciab90.auth.ui.components.register

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme

@Composable
fun RegisterScreen(
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar =  { },
        content = {
            pageContent(it)
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    AssemblyBoardAppTheme {
        RegisterScreen { paddingValues ->
            RegisterContent(
                modifier = Modifier.padding(paddingValues),
                onRegisterClick = {},
                onLoginClick = {}
            )
        }
    }
}