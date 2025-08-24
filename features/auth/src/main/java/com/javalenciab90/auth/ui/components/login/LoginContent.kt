package com.javalenciab90.auth.ui.components.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.auth.ui.components.GoogleButton
import com.javalenciab90.auth.ui.viewmodel.login.LoginContract
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
    uiState: LoginContract.State,
    onHandleIntent: (LoginContract.Intent) -> Unit
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
        InputLoginForm(
            uiState = uiState,
            onHandleIntent = { onHandleIntent(it) }
        )

        VerticalSeparator(Dimens.All_32)
        ContainedButton(
            onClick = { onHandleIntent(LoginContract.Intent.SignInWithEmail) }
        ) {
            GenericButtonContent(
                label = "Iniciar sesión"
            )
        }

        VerticalSeparator(Dimens.All_48)
        GoogleButton(
            description = "Inicia sesión con Google"
        ) {
            onHandleIntent(LoginContract.Intent.SignInWithGoogle)
        }

        VerticalSeparator(Dimens.All_32)
        RegisterTextAction {
            onHandleIntent(LoginContract.Intent.RegisterAction)
        }
    }
}

@Composable
fun RegisterTextAction(
    onRegisterClick: () -> Unit
) {
    Label(
        modifier = Modifier.clickable {
            onRegisterClick()
        },
        text = "register",
        textDecoration = TextDecoration.Underline,
        style = MaterialTheme.typography.labelMedium
    )
}

@Preview(showBackground = true)
@Composable
private fun LoginContentPreview() {
    AssemblyBoardAppTheme {
        ColumnPresenter {
            LoginContent(
                uiState = LoginContract.State(),
                onHandleIntent = { }
            )
        }
    }
}