package com.ghzel.contactstream.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ghzel.contactstream.R

val ubuntu = FontFamily(
    Font(R.font.ubuntu_bold, FontWeight.W600),
    Font(R.font.ubuntu_mediumitalic, FontWeight.W400),
    Font(R.font.ubuntu_light, FontWeight.Light),
    Font(R.font.ubuntu_medium, FontWeight.Medium),
    Font(R.font.ubuntu_regular, FontWeight.Normal),
    Font(R.font.ubuntu_bolditalic, FontWeight.SemiBold),
    Font(R.font.ubuntu_lightitalic, FontWeight.ExtraLight),
    Font(R.font.ubuntu_italic, FontWeight.Thin),

)
val UbuntuTypography = androidx.compose.material3.Typography(
    displayLarge = TextStyle(
        fontFamily = ubuntu,
        fontWeight = FontWeight.W600,
        color = main_color,
        fontSize = 18.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = ubuntu,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = ubuntu,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = ubuntu,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = ubuntu,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = ubuntu,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = ubuntu,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = ubuntu,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    ),
)
