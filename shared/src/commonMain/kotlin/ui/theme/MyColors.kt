package ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class MyColors internal constructor(
    val transparent: Color = Color(0x00000000),
    val background: Color,
    val text: Color,
    val textInverse: Color,
    val hint: Color,
    val surface: Color,
    val primary: Color,
) {
    companion object {
        val dark
            get() = MyColors(
                background = Color(0xFF000000),
                text = Color(0xFFFFFFFF),
                textInverse = Color(0xFF000000),
                hint = Color(0xFFFFFFFF).copy(alpha = 0.5F),
                surface = Color(0xFF171717),
                primary = Color(0xFFDCF96D),
            )

        val light
            get() = MyColors(
                background = Color(0xFFFFFFFF),
                text = Color(0xFF000000),
                textInverse = Color(0xFFFFFFFF),
                hint = Color(0xFF000000).copy(alpha = 0.5F),
                surface = Color(0xFFF2F2F2),
                primary = Color(0xFF0418A2),
            )
    }
}