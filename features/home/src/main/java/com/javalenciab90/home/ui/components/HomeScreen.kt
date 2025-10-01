package com.javalenciab90.home.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    pageContent: @Composable (PaddingValues) -> Unit,
    onProfileClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.wrapContentHeight(),
                title = { Text("") },
                actions = {
                    IconButton(onClick = onProfileClick) {
                        Icon(
                            imageVector = Icons.Default.Person, contentDescription = "Perfil"
                        )
                    }
                    IconButton(onClick = onLogoutClick) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp, contentDescription = "Cerrar sesión"
                        )
                        //Todo: crear un dialogo para confirmar la salida
                    }
                }
            )
        },
        content = {
            pageContent(it)
        }
    )
}