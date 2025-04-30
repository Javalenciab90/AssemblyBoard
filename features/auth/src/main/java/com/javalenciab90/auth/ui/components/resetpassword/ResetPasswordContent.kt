package com.javalenciab90.auth.ui.components.resetpassword

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
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.auth.R
import com.javalenciab90.auth.ui.components.InputTextField
import com.javalenciab90.design_system.components.button.ContainedButton
import com.javalenciab90.design_system.components.button.GenericButtonContent
import com.javalenciab90.design_system.components.preview.ColumnPresenter
import com.javalenciab90.design_system.components.separators.VerticalSeparator
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun ResetPasswordContent(
    modifier: Modifier = Modifier,
    onSubmitEmail: (String) -> Unit
) {


    Column(
        modifier = modifier.padding(horizontal = Dimens.All_16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Label(
            modifier = Modifier.fillMaxWidth(),
            text = "Olvidaste tu contraseña",
            style = MaterialTheme.typography.titleLarge
        )

        Label(
            modifier = Modifier.fillMaxWidth(),
            text = "Ingresa tu correo electrónico y te enviaremos un enlace para restablecer tu contraseña"
        )

        VerticalSeparator(Dimens.All_48)

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

        VerticalSeparator(Dimens.All_32)

        ContainedButton(
            onClick = { }
        ) {
            GenericButtonContent(
                label = "Enviar correo de recuperación"
            )
        }
    }
}

@Preview
@Composable
private fun ResetPasswordContentPreview() {
    AssemblyBoardAppTheme {
        ColumnPresenter {
            ResetPasswordContent() {}
        }
    }
}