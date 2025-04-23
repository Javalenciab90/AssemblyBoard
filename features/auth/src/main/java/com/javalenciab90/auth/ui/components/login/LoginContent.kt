package com.javalenciab90.auth.ui.components.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.auth.R
import com.javalenciab90.auth.ui.components.GoogleButton
import com.javalenciab90.auth.ui.components.InputTextField
import com.javalenciab90.design_system.components.button.ContainedButton
import com.javalenciab90.design_system.components.button.GenericButtonContent
import com.javalenciab90.design_system.components.preview.ColumnPresenter
import com.javalenciab90.design_system.components.separators.VerticalSeparator
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    onForgotPassword: () -> Unit
) {
    Column (
        modifier = modifier.padding(horizontal = Dimens.All_16),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Label(
            modifier = Modifier.fillMaxWidth(),
            text = "Iniciar Sesión",
            style = MaterialTheme.typography.titleLarge
        )
        Label(
            modifier = Modifier.fillMaxWidth(),
            text = "Inicia sesión para ingresar a las asambleas de coopropietarios"
        )
        VerticalSeparator(Dimens.All_48)
        InputLoginForm(onForgotPassword)
        VerticalSeparator(Dimens.All_32)
        ContainedButton(
            onClick = { }
        ) {
            GenericButtonContent(
                label = "Iniciar sesión"
            )
        }
        VerticalSeparator(Dimens.All_48)
        GoogleButton(
            description = "Inicia sesión con Google"
        )
    }
}

@Composable
private fun InputLoginForm(onForgotPassword: () -> Unit) {
    Column(
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

@Preview(showBackground = true)
@Composable
private fun LoginContentPreview() {
    AssemblyBoardAppTheme {
        ColumnPresenter {
            LoginContent() {}
        }
    }
}