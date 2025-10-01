package com.javalenciab90.design_system.components.dialog

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.design_system.components.button.ContainedButton
import com.javalenciab90.design_system.components.button.GenericButtonContent
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun ConfirmationDialog(
    isVisible: Boolean,
    @StringRes title: Int,
    @StringRes message: Int,
    @DrawableRes icon: Int? = null,
    @StringRes confirmButtonText: Int,
    @StringRes cancelButtonText: Int,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (isVisible) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Label(
                    text = stringResource(title),
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }, icon = icon?.let { iconVector ->
                {
                    Icon(
                        painter = painterResource(iconVector),
                        contentDescription = null,
                        modifier = Modifier.size(Dimens.All_48),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            text = {
                Label(
                    text = stringResource(message),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                ContainedButton(
                    onClick = onConfirm,
                    modifier = Modifier.padding(end = Dimens.All_8)
                ) {
                    GenericButtonContent(
                        label = stringResource(confirmButtonText)
                    )
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = onDismiss
                ) {
                    GenericButtonContent(
                        label = stringResource(cancelButtonText)
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ConfirmationDialogPreview() {
    AssemblyBoardAppTheme {
        ConfirmationDialog(
            isVisible = true,
            title = 0,
            message = 0,
            icon = 0,
            confirmButtonText = 0,
            cancelButtonText = 0,
            onConfirm = { },
            onDismiss = { }
        )
    }
}