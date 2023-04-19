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
    val divider: Color,
    val primary: Color,
)

internal fun MyColors() = MyColors(
    background = Color(0xFFFFFFFF),
    text = Color(0xFF1B1C20),
    textInverse = Color(0xFFFCFCFC),
    surface = Color(0xFFFCFCFC),
    divider = Color(0xFFF1F1F1),
    primary = Color(0xFF2242DA),
)