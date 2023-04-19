package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import ui.resources.font

internal object MyFonts {
    private const val SPACE_MONO = "Space Mono"
    private const val SORA = "Space Grotesk"
    private const val DM_SANS = "DM Sans"

    val Sora
        @Composable
        get() = FontFamily(
            font(
                name = SORA,
                res = "sora_extrabold",
                weight = FontWeight.ExtraBold,
                style = FontStyle.Normal
            ),
            font(
                name = SORA,
                res = "sora_bold",
                weight = FontWeight.Bold,
                style = FontStyle.Normal
            ),
            font(
                name = SORA,
                res = "sora_medium",
                weight = FontWeight.Medium,
                style = FontStyle.Normal
            ),
            font(
                name = SORA,
                res = "sora_semibold",
                weight = FontWeight.SemiBold,
                style = FontStyle.Normal
            ),
            font(
                name = SORA,
                res = "sora_regular",
                weight = FontWeight.Normal,
                style = FontStyle.Normal
            ),
            font(
                name = SORA,
                res = "sora_light",
                weight = FontWeight.Light,
                style = FontStyle.Normal
            ),
            font(
                name = SORA,
                res = "sora_extralight",
                weight = FontWeight.ExtraLight,
                style = FontStyle.Normal
            ),
            font(
                name = SORA,
                res = "sora_thin",
                weight = FontWeight.Thin,
                style = FontStyle.Normal
            ),
        )

    val DmSans
        @Composable
        get() = FontFamily(
            font(
                name = DM_SANS,
                res = "dmsans_bold",
                weight = FontWeight.Bold,
                style = FontStyle.Normal
            ),
            font(
                name = DM_SANS,
                res = "dmsans_medium",
                weight = FontWeight.Medium,
                style = FontStyle.Normal
            ),
            font(
                name = DM_SANS,
                res = "dmsans_regular",
                weight = FontWeight.Normal,
                style = FontStyle.Normal
            ),
        )
}