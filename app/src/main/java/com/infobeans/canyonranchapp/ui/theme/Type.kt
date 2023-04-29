package com.infobeans.canyonranchapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.infobeans.canyonranchapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

private val cormorant_garamond = FontFamily(
    Font(R.font.cormorant_garamond_regular),
    Font(R.font.cormorant_garamond_bold, FontWeight.W500),
    Font(R.font.proxima_nova_semi_bold, FontWeight.W600)
)

private val proxima_nova = FontFamily(
    Font(R.font.proxima_nova_regular),
    Font(R.font.proxima_nova_medium, FontWeight.W500),
    Font(R.font.proxima_nova_semi_bold, FontWeight.W600)
)


val CanyonRanchTypography = Typography(
    h1 = TextStyle(
        fontFamily = cormorant_garamond,
        fontWeight = FontWeight.W600,
        fontSize = 44.sp
    ),
    h2 = TextStyle(
        fontFamily = proxima_nova,
        fontWeight = FontWeight.W600,
        fontSize = 36.sp
    ),
    h3 = TextStyle(
        fontFamily = proxima_nova,
        fontWeight = FontWeight.W600,
        fontSize = 22.sp
    ),
    h4 = TextStyle(
        fontFamily = proxima_nova,
        fontWeight = FontWeight.W600,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = proxima_nova,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),

    h6 = TextStyle(
        fontFamily = proxima_nova,
        fontWeight = FontWeight.W600,
        fontSize = 15.sp
    ),

    /*subtitle1 = TextStyle(
        fontFamily = proxima_nova,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),

    subtitle2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),*/
    body1 = TextStyle(
        fontFamily = proxima_nova,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    body2 = TextStyle(
        fontFamily = proxima_nova,
        fontSize = 18.sp
    ),

    button = TextStyle(
        fontFamily = proxima_nova,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp
    ),

    /*caption = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )*/
)