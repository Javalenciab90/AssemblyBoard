package com.javalenciab90.auth.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.javalenciab90.design_system.components.textfield.GenericTextField
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    icon: (@Composable () -> Unit)? = null
) {
    GenericTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
        label = label,
        shape = RoundedCornerShape(Dimens.All_12),
        isError = isError,
        leadingIcon = icon,
        visualTransformation = visualTransformation
    )
}