package ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
class MyColors internal constructor(
    val transparent: Color = Color(0x00000000),
    val background: Color,
    val text: Color,
    val textInverse: Color,
    val surface: Color,
    val primary: Color,
)

internal fun MyColors() = MyColors(
    background = Color(0xFF000000),
    text = Color(0xFFFFFFFF),
    textInverse = Color(0xFF000000),
    surface = Color(0xFF171717),
    primary = Color(0xFFFFD13F),
)