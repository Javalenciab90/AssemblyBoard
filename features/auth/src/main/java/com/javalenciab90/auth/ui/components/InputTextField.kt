package com.javalenciab90.auth.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.javalenciab90.design_system.components.textfield.GenericTextField
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun InputTextField(
    value: String,
    label: String,
    isError: Boolean = false,
    icon: (@Composable () -> Unit)? = null
) {
    GenericTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        label = label,
        shape = RoundedCornerShape(Dimens.All_12),
        isError = isError,
        leadingIcon = icon
    )
}