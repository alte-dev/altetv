/*
 * This file is part of OpenTV.
 * Copyright (C) 2026 The OpenTV Contributors
 * Licensed under the GNU General Public License v3.0 or later.
 */
package app.opentv.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * A deliberately dark, low-chroma palette.
 *
 * This is a living-room app: it is looked at in a dark room, from three metres away, often
 * for hours. Bright surfaces and saturated accents that read well on a phone in daylight are
 * actively unpleasant on a 55" panel at night, so everything here is anchored near-black with
 * a single restrained accent used only for focus and selection.
 */
private val Accent = Color(0xFFFF7F00)       // Warm vibrant brand orange
private val AccentDim = Color(0xFFB93D46)    // Warm rich ruby red

private val DarkScheme = darkColorScheme(
    primary = Accent,
    onPrimary = Color(0xFF121212),
    primaryContainer = Color(0xFF381F17),
    onPrimaryContainer = Color(0xFFFFD9CC),
    secondary = Color(0xFFE58055),
    onSecondary = Color(0xFF121212),
    secondaryContainer = Color(0xFF2C2220),
    onSecondaryContainer = Color(0xFFE8D4CC),
    background = Color(0xFF121212),          // Neutral dark gray (no blue/navy)
    onBackground = Color(0xFFEDEDED),
    surface = Color(0xFF181818),             // Neutral dark gray surface
    onSurface = Color(0xFFEDEDED),
    surfaceVariant = Color(0xFF242424),      // Neutral medium-dark gray
    onSurfaceVariant = Color(0xFFA4A4A4),    // Neutral secondary text
    outline = Color(0xFF333333),             // Neutral divider/border
    outlineVariant = Color(0xFF282828),
    error = Color(0xFFFF5252),
    onError = Color(0xFF180404),
)

/**
 * Light mode for anyone who wants it. By default TV boxes stay dark (a white living-room
 * screen at night is nobody's friend) — that default lives at the call site, so a user who
 * explicitly picks Light in settings gets it on any device.
 */
private val LightScheme = lightColorScheme(
    primary = Color(0xFFD66000),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFDBCF),
    onPrimaryContainer = Color(0xFF381400),
    secondary = Color(0xFFB93D46),
    onSecondary = Color.White,
    background = Color(0xFFF8F8F8),
    onBackground = Color(0xFF181818),
    surface = Color.White,
    onSurface = Color(0xFF181818),
    surfaceVariant = Color(0xFFEEEEEE),
    onSurfaceVariant = Color(0xFF555555),
    outline = Color(0xFFD8D8D8),
)

/** Scaled up from the Material defaults: ten-foot viewing needs bigger text than a phone. */
private val OpenTvTypography = Typography(
    displaySmall = TextStyle(fontSize = 34.sp, fontWeight = FontWeight.SemiBold),
    headlineMedium = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.SemiBold),
    headlineSmall = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold),
    titleLarge = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
    titleMedium = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.Medium),
    bodyLarge = TextStyle(fontSize = 16.sp),
    bodyMedium = TextStyle(fontSize = 14.sp),
    labelLarge = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
)

@Composable
fun OpenTvTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkScheme else LightScheme,
        typography = OpenTvTypography,
        content = content,
    )
}
