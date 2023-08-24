package ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class MyColors internal constructor(
    val transparent: Color = Color(0x00000000),
    val background: Color,
    val text: Color,
    val textInverse: Color,
    val surface: Color,
    val primary: Color,
) {
    companion object {
        val dark
            get() = MyColors(
                background = Color(0xFF000000),
                text = Color(0xFFFFFFFF),
                textInverse = Color(0xFF000000),
                surface = Color(0xFF171717),
                primary = Color(0xFFFBE75D),
            )

        val light
            get() = MyColors(
                background = Color(0xFFFFFFFF),
                text = Color(0xFF000000),
                textInverse = Color(0xFFFFFFFF),
                surface = Color(0xFFE8E8E8),
                primary = Color(0xFF0418A2),
            )
    }
}