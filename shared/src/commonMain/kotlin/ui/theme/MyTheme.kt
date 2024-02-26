@file:OptIn(ExperimentalObjCRefinement::class)

package ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import kotlin.experimental.ExperimentalObjCRefinement

internal val LocalMyThemeColors = staticCompositionLocalOf { MyColors.light }
internal val LocalMyThemeTypography = staticCompositionLocalOf { MyTypography() }
internal val LocalMyThemeDimensions = staticCompositionLocalOf { MyDimens() }

internal object MyTheme {
    val colors: MyColors
        @Composable
        get() = LocalMyThemeColors.current

    val typography: MyTypography
        @Composable
        get() = LocalMyThemeTypography.current

    val dimensions: MyDimens
        @Composable
        get() = LocalMyThemeDimensions.current
}

@Composable
fun MyTheme(
    colors: MyColors = MyTheme.colors,
    typography: MyTypography = MyTheme.typography,
    dimensions: MyDimens = MyTheme.dimensions,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalMyThemeColors provides colors,
        LocalMyThemeTypography provides typography,
        LocalMyThemeDimensions provides dimensions,
        LocalIndication provides rememberRipple(),
        LocalRippleTheme provides MyRipple,
        content = content,
    )
}