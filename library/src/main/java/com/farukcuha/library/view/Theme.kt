package com.farukcuha.library.view

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun AppTheme(
    darkColorScheme: ColorScheme = darkColorScheme(
        primary = Color(0xffA81C27),
        onPrimary = Color.Black,

        secondary = Color(0xff231F20),
        onSecondary = Color.White
    ),
    lightColorScheme: ColorScheme = lightColorScheme(
        primary = Color(0xffA81C27),
        onPrimary = Color.Black,

        secondary = Color(0xff231F20),
        onSecondary = Color.White
    ),
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}