package com.javalenciab90.auth.ui.components.register

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
import com.javalenciab90.auth.ui.viewmodel.register.RegisterContract
import com.javalenciab90.design_system.components.button.ContainedButton
import com.javalenciab90.design_system.components.button.GenericButtonContent
import com.javalenciab90.design_system.components.preview.ColumnPresenter
import com.javalenciab90.design_system.components.separators.VerticalSeparator
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun RegisterContent(
    modifier: Modifier = Modifier,
    uiState: RegisterContract.State,
    onHandleIntent: (RegisterContract.Intent) -> Unit
) {
    Column(
        modifier = modifier.padding(horizontal = Dimens.All_16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Label(
            modifier = Modifier.fillMaxWidth(),
            text = "Registro",
            style = MaterialTheme.typography.titleLarge
        )
        Label(
            modifier = Modifier.fillMaxWidth(),
            text = "Crea una nueva cuenta para acceder a las asambleas de coopropietarios"
        )
        VerticalSeparator(Dimens.All_48)
        InputRegisterForm(
            email = uiState.email,
            password = uiState.password,
            confirmPassword = uiState.confirmPassword,
            onHandleIntent = { onHandleIntent(it) }
        )
        VerticalSeparator(Dimens.All_32)
        ContainedButton(
            onClick = {
                onHandleIntent(RegisterContract.Intent.RegisterAction)
            }
        ) {
            GenericButtonContent(
                label = "Registrar"
            )
        }
        VerticalSeparator(Dimens.All_32)
        LoginTextAction {
            onHandleIntent(RegisterContract.Intent.LoginAction)
        }
    }
}

@Composable
fun LoginTextAction(
    onLoginClick: () -> Unit
) {
    Label(
        modifier = Modifier.clickable {
            onLoginClick()
        },
        text = "Iniciar sesión",
        textDecoration = TextDecoration.Underline,
        style = MaterialTheme.typography.labelMedium
    )
}

@Preview(showBackground = true)
@Composable
private fun LoginContentPreview() {
    AssemblyBoardAppTheme {
        ColumnPresenter {
            RegisterContent(
                uiState = RegisterContract.State(),
                onHandleIntent = {}
            )
        }
    }
}