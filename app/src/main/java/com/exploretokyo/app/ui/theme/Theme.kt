package com.exploretokyo.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = IndigoPrimary,
    onPrimary = OnPrimaryWhite,
    primaryContainer = IndigoPrimaryLight,
    onPrimaryContainer = OnPrimaryWhite,
    secondary = SakuraPink,
    onSecondary = OnSurfaceDark,
    secondaryContainer = SakuraPinkLight,
    onSecondaryContainer = OnSurfaceDark,
    tertiary = ToriiVermillion,
    onTertiary = OnPrimaryWhite,
    tertiaryContainer = ToriiVermillionLight,
    onTertiaryContainer = OnSurfaceDark,
    background = WarmCream,
    onBackground = OnSurfaceDark,
    surface = WarmCream,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurfaceVariant,
    outline = OutlineColor,
    outlineVariant = OutlineLightColor
)

private val DarkColorScheme = darkColorScheme(
    primary = IndigoPrimaryLight,
    onPrimary = OnPrimaryWhite,
    primaryContainer = IndigoPrimary,
    onPrimaryContainer = OnPrimaryWhite,
    secondary = SakuraPink,
    onSecondary = OnSurfaceDark,
    secondaryContainer = SakuraPinkDark,
    onSecondaryContainer = DarkOnSurface,
    tertiary = ToriiVermillionLight,
    onTertiary = OnPrimaryWhite,
    background = DarkSurface,
    onBackground = DarkOnSurface,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurface,
    outline = OutlineColor,
    outlineVariant = OutlineLightColor
)

@Composable
fun ExploreTokyoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
