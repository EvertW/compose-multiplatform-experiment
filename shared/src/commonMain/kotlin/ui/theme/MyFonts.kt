package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import ui.resources.font

internal object MyFonts {
    private const val SPACE_MONO = "Space Mono"
    private const val SPACE_GROTESK = "Space Grotesk"
    private const val DM_SANS = "DM Sans"

    val SpaceGrotesk
        @Composable
        get() = FontFamily(
            font(
                name = SPACE_GROTESK,
                res = "spacegrotesk_bold",
                weight = FontWeight.Bold,
                style = FontStyle.Normal
            ),
            font(
                name = SPACE_GROTESK,
                res = "spacegrotesk_medium",
                weight = FontWeight.Medium,
                style = FontStyle.Normal
            ),
            font(
                name = SPACE_GROTESK,
                res = "spacegrotesk_semibold",
                weight = FontWeight.SemiBold,
                style = FontStyle.Normal
            ),
            font(
                name = SPACE_GROTESK,
                res = "spacegrotesk_regular",
                weight = FontWeight.Normal,
                style = FontStyle.Normal
            ),
            font(
                name = SPACE_GROTESK,
                res = "spacegrotesk_light",
                weight = FontWeight.Light,
                style = FontStyle.Normal
            ),
        )

    val SpaceMono
        @Composable
        get() = FontFamily(
            font(
                name = SPACE_MONO,
                res = "spacemono_bold",
                weight = FontWeight.Bold,
                style = FontStyle.Normal
            ),
            font(
                name = SPACE_MONO,
                res = "spacemono_regular",
                weight = FontWeight.Normal,
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