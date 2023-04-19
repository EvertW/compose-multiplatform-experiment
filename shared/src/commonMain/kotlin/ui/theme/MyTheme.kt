@file:OptIn(ExperimentalObjCRefinement::class)

package ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import kotlin.experimental.ExperimentalObjCRefinement

internal val DefaultColors = MyColors()

internal val LocalMyThemeColors = staticCompositionLocalOf { DefaultColors }
internal val LocalMyThemeTypography = staticCompositionLocalOf { MyTypography(DefaultColors) }
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
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MyTheme.colors.background)
            ) {
                content.invoke()
            }
        },
    )
}