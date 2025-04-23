package com.javalenciab90.auth.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.javalenciab90.auth.R
import com.javalenciab90.design_system.components.button.GenericButtonDefaults
import com.javalenciab90.design_system.components.text.Label
import com.javalenciab90.design_system.theme.Dimens

@Composable
fun GoogleButton(
    description: String
) {
    OutlinedButton(
        shape = RoundedCornerShape(Dimens.All_12),
        contentPadding =  GenericButtonDefaults.ContentPadding,
        border = BorderStroke(
            width = Dimens.All_1,
            color = MaterialTheme.colorScheme.primary
        ),
        onClick = { },
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimens.All_8),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_google),
                    tint = Color.Unspecified,
                    contentDescription = null
                )
                Label(
                    text = description
                )
            }
        }
    )
}

