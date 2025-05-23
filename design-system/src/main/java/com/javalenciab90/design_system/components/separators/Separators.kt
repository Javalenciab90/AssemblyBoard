package com.javalenciab90.design_system.components.separators

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun VerticalSeparator(
    size: Dp
) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun HorizontalSeparator(
    size: Dp
) {
    Spacer(modifier = Modifier.width(size))
}