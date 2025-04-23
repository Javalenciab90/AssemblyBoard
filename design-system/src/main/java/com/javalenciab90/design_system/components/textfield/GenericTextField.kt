package com.javalenciab90.design_system.components.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.javalenciab90.design_system.theme.errorLight
import com.javalenciab90.design_system.theme.outlineLight
import com.javalenciab90.design_system.theme.outlineVariantLight

@Composable
fun GenericTextField(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    readOnly: Boolean = false,
    isError: Boolean = false,
    supportingText: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    singleLine: Boolean = false,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        modifier = modifier,
        readOnly = readOnly,
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = outlineVariantLight,
            focusedBorderColor = outlineLight,
            errorSupportingTextColor = errorLight,
            errorBorderColor = errorLight
        ),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        label = {
            Text(
                text = label,
                color = outlineLight
            )
        },
        supportingText = supportingText,
        interactionSource = interactionSource,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine
    )
}