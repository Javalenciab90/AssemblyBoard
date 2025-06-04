package com.javalenciab90.design_system.components.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.Dimens
import com.javalenciab90.design_system.theme.outlineLight

@Composable
fun GenericTextField(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(Dimens.All_4),
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
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = modifier,
        readOnly = readOnly,
        value = value,
        onValueChange = onValueChange,
        isError = isError,
        shape = shape,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            errorSupportingTextColor = MaterialTheme.colorScheme.error,
            errorBorderColor = MaterialTheme.colorScheme.error
        ),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        label = {
            Label(
                text = label,
                color = MaterialTheme.colorScheme.outlineVariant,
                style = MaterialTheme.typography.labelMedium
            )
        },
        visualTransformation = visualTransformation,
        supportingText = supportingText,
        interactionSource = interactionSource,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine
    )
}