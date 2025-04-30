package com.javalenciab90.design_system.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import com.javalenciab90.design_system.theme.Dimens

object GenericButtonDefaults {
    private val ButtonHorizontalPadding = Dimens.All_24
    private val ButtonVerticalPadding = Dimens.All_12
    private val ButtonOnlyIconHorizontalPadding = Dimens.All_12

    val ButtonShape = RoundedCornerShape(Dimens.All_6)
    val MinHeight = Dimens.All_48
    val MinWidth = Dimens.All_1

    val ContentPadding =
        PaddingValues(
            start = ButtonHorizontalPadding,
            top = ButtonVerticalPadding,
            end = ButtonHorizontalPadding,
            bottom = ButtonVerticalPadding
        )

    val ButtonOnlyIconContentPadding =
        PaddingValues(
            start = ButtonOnlyIconHorizontalPadding,
            top = ButtonVerticalPadding,
            end = ButtonOnlyIconHorizontalPadding,
            bottom = ButtonVerticalPadding
        )
}