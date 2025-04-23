package com.javalenciab90.design_system.components.button

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.javalenciab90.design_system.theme.AssemblyBoardAppTheme
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun GenericButtonContent(
    label: String,
    modifier: Modifier = Modifier,
    leftIcon: (@Composable () -> Unit)? = null,
    rightIcon: (@Composable () -> Unit)? = null,
    textAlign: TextAlign = TextAlign.Center,
    textOverflow: TextOverflow = TextOverflow.Clip,
    textMaxLines: Int = Int.MAX_VALUE,
    centerContent: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        leftIcon?.let { icon ->
            icon()
            Spacer(modifier = Modifier.width(Dimens.All_10))
        }
        Text(
            modifier = Modifier.then(
                    if ((leftIcon != null || rightIcon != null) && !centerContent) {
                        Modifier.weight(Dimens.Weight1)
                    } else {
                        Modifier
                    }
                ),
            text = label,
            fontWeight = FontWeight.Bold,
            textAlign = textAlign,
            maxLines = textMaxLines,
            overflow = textOverflow
        )
        rightIcon?.let { icon ->
            Spacer(modifier = Modifier.width(Dimens.All_10))
            icon()
        }
    }
}

@Preview
@Composable
fun GenericButtonContentPreview() {
    AssemblyBoardAppTheme {
        GenericButtonContent(
            label = "Some button"
        )
    }
}