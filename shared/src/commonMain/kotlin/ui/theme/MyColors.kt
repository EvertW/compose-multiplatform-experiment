package ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
class MyColors internal constructor(
    val transparent: Color = Color(0x00000000),
    val background: Color,
    val text: Color,
    val surface: Color,
    val divider: Color,
    val primary: Color,
    val secondary: Color,
)

internal fun MyColors() = MyColors(
    background = Color(0xFFFFFFFF),
    text = Color(0xFF014751),
    surface = Color(0xFFF8FBFF),
    divider = Color(0x14014751),
    primary = Color(0xFFAFF8C8),
    secondary = Color(0xFFFFEEB4),
)