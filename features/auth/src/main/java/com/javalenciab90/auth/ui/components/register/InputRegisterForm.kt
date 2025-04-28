package com.javalenciab90.auth.ui.components.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.javalenciab90.auth.R
import com.javalenciab90.auth.ui.components.InputTextField
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun InputRegisterForm(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Dimens.All_25)
    ) {
        InputTextField(
            value = "",
            label = "email",
            icon = {
                Icon(
                    modifier = Modifier.size(Dimens.All_18),
                    painter = painterResource(R.drawable.ic_email_arroba),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null
                )
            }
        )
        InputTextField(
            value = "",
            label = "contraseña",
            isError = false,
            icon = {
                Icon(
                    modifier = Modifier.size(Dimens.All_18),
                    painter = painterResource(R.drawable.ic_email_password),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null
                )
            }
        )
        InputTextField(
            value = "",
            label = "confirmar contraseña",
            isError = false,
            icon = {
                Icon(
                    modifier = Modifier.size(Dimens.All_18),
                    painter = painterResource(R.drawable.ic_email_password),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null
                )
            }
        )
    }
}