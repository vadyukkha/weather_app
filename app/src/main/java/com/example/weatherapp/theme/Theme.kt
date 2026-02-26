package com.example.weatherapp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = SkyBlue,
    onPrimary = SurfaceLight,
    primaryContainer = SkyContainer,
    onPrimaryContainer = SkyBlueDark,

    secondary = SunAccent,
    onSecondary = SurfaceLight,

    background = BackgroundLight,
    onBackground = SkyBlueDark,

    surface = SurfaceLight,
    onSurface = SkyBlueDark
)

private val DarkColors = darkColorScheme(
    primary = NightBlueLight,
    onPrimary = SurfaceDark,
    primaryContainer = NightContainer,
    onPrimaryContainer = NightBlueLight,

    secondary = SunAccent,
    onSecondary = SurfaceDark,

    background = BackgroundDark,
    onBackground = NightBlueLight,

    surface = SurfaceDark,
    onSurface = NightBlueLight
)

@Composable
fun WeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}