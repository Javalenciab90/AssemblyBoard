package com.javalenciab90.design_system.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.design_system.components.preview.ColumnPresenter
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme

@Composable
fun ContainedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = GenericButtonDefaults.ContentPadding,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier.defaultMinSize(
            minWidth = GenericButtonDefaults.MinWidth,
            minHeight = GenericButtonDefaults.MinHeight
        ),
        shape = GenericButtonDefaults.ButtonShape,
        contentPadding = contentPadding,
        onClick = onClick,
        enabled = enabled,
        content = content
    )
}

@Composable
@Preview(showBackground = true)
private fun ContainedAetherButtonPreview() {
    AssemblyBoardAppTheme {
        ColumnPresenter {
            ContainedButton(
                onClick = {},
                content = {
                    GenericButtonContent(
                        label = "Submit"
                    )
                }
            )
        }
    }
}