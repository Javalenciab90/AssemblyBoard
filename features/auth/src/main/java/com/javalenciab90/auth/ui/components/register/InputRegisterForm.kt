package com.javalenciab90.auth.ui.components.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.javalenciab90.auth.R
import com.javalenciab90.auth.ui.components.InputTextField
import com.javalenciab90.auth.ui.viewmodel.register.RegisterContract
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun InputRegisterForm(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    confirmPassword: String,
    onHandleIntent: (RegisterContract.Intent) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Dimens.All_25)
    ) {
        InputTextField(
            value = email,
            onValueChange = {
                onHandleIntent(RegisterContract.Intent.UpdateEmail(it))
            },
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
            value = password,
            onValueChange = {
                onHandleIntent(RegisterContract.Intent.UpdatePassword(it))
            },
            label = "contraseña",
            visualTransformation = PasswordVisualTransformation(),
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
            value = confirmPassword,
            onValueChange = {
                onHandleIntent(RegisterContract.Intent.UpdateConfirmPassword(it))
            },
            label = "confirmar contraseña",
            visualTransformation = PasswordVisualTransformation(),
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