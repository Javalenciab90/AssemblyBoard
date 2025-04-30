package com.javalenciab90.auth.ui.components.resetpassword

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import com.javalenciab90.auth.R
import com.javalenciab90.design_system.theme.Dimens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen (
    onHandleIntent: Unit,
    onBack: () -> Unit,
    pageContent: @Composable (PaddingValues) -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.wrapContentHeight(),
                title = { Text("")},
                navigationIcon = {
                    IconButton(
                        onClick = { onBack() }
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(start = Dimens.All_16)
                                .size(Dimens.All_25),
                            painter = painterResource(id = R.drawable.back_arrow),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = {
            pageContent(it)
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ResetPasswordScreenPreview() {
    AssemblyBoardAppTheme {
        ResetPasswordScreen(
            onHandleIntent = Unit,
            onBack = {}
        ) { paddingValues ->
            ResetPasswordContent (
                modifier = Modifier.padding(paddingValues)
            ) { }
        }
    }
}