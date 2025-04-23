package com.javalenciab90.auth.ui.components.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.design_system.components.preview.ColumnPresenter
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun LoginContent(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.fillMaxSize().padding(horizontal = Dimens.All_16)
    ) {
        Label(
            modifier = Modifier.fillMaxWidth(),
            text = "Iniciar Sesión",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginContentPreview() {
    AssemblyBoardAppTheme {
        ColumnPresenter {
            LoginContent()
        }
    }
}