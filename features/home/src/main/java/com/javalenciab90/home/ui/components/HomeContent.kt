package com.javalenciab90.home.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.javalenciab90.design_system.components.loading.LoadingScreen
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.Dimens
import com.javalenciab90.home.ui.viewmodel.HomeContract
import com.javalenciab90.home.ui.viewmodel.Status

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    uiState: HomeContract.State,
    onHandleIntent: (HomeContract.Intent) -> Unit
) {
    Column(
        modifier = modifier.padding(horizontal = Dimens.All_16),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (uiState.status) {
            is Status.Loading -> {
                LoadingScreen()
            }
            is Status.Success -> {
                Label(
                    text = "CurrentUser: ${uiState.status.currentUser}",
                    style = MaterialTheme.typography.titleLarge
                )
                Button(
                    onClick = { onHandleIntent(HomeContract.Intent.SignOut) }
                ) {
                    Text(text = "Sign Out")
                }
                // Show data
            }
            is Status.Error -> {
                Label(
                    text = "Error",
                    style = MaterialTheme.typography.titleLarge
                )
                Button(
                    onClick = { onHandleIntent(HomeContract.Intent.SignOut) }
                ) {
                    Text(text = "Back to Login")
                }
                // Show error message
            }
        }
    }
}