package com.javalenciab90.auth.ui.components.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import com.javalenciab90.auth.R
import com.javalenciab90.auth.ui.components.InputTextField
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun InputLoginForm(
    modifier: Modifier = Modifier,
    onForgotPassword: () -> Unit
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
                    tint = MaterialTheme.colorScheme.primary, contentDescription = null
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
        Label(
            modifier = Modifier.clickable { onForgotPassword() },
            text = "¿Olvidaste tu contraseña?",
            textDecoration = TextDecoration.Underline,
            style = MaterialTheme.typography.labelMedium
        )
    }
}