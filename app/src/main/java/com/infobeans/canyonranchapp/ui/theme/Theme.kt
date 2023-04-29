package com.infobeans.canyonranchapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Chocolate500, //main background color
    primaryVariant = Chocolate500, //grid lines of app
    secondary = Teal200 //used for text color
)

private val LightColorPalette = lightColors(
    primary = Chocolate500,
    primaryVariant = Chocolate500,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White, //background of app
    onPrimary = Color.White, //main background color
    onSecondary = Color.Black, //used for text color
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CanyonRanchAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        /*typography = Typography,*/
        typography = CanyonRanchTypography,
        shapes = Shapes,
        content = content
    )
}