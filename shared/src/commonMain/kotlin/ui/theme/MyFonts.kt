package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.evertwoud.multiplatform.example.MR
import dev.icerock.moko.resources.compose.asFont

internal object MyFonts {
    val Sora
        @Composable
        get() = FontFamily(
            listOfNotNull(
                MR.fonts.sora.extrabold.asFont(
                    weight = FontWeight.ExtraBold,
                    style = FontStyle.Normal
                ),
                MR.fonts.sora.bold.asFont(
                    weight = FontWeight.Bold,
                    style = FontStyle.Normal
                ),
                MR.fonts.sora.medium.asFont(
                    weight = FontWeight.Medium,
                    style = FontStyle.Normal
                ),
                MR.fonts.sora.semibold.asFont(
                    weight = FontWeight.SemiBold,
                    style = FontStyle.Normal
                ),
                MR.fonts.sora.regular.asFont(
                    weight = FontWeight.Normal,
                    style = FontStyle.Normal
                ),
                MR.fonts.sora.light.asFont(
                    weight = FontWeight.Light,
                    style = FontStyle.Normal
                ),
                MR.fonts.sora.extralight.asFont(
                    weight = FontWeight.ExtraLight,
                    style = FontStyle.Normal
                ),
                MR.fonts.sora.thin.asFont(
                    weight = FontWeight.Thin,
                    style = FontStyle.Normal
                ),
            )
        )

    val DmSans
        @Composable
        get() = FontFamily(
            listOfNotNull(
                MR.fonts.dmsans.bold.asFont(
                    weight = FontWeight.Bold,
                    style = FontStyle.Normal
                ),
                MR.fonts.dmsans.medium.asFont(
                    weight = FontWeight.Medium,
                    style = FontStyle.Normal
                ),
                MR.fonts.dmsans.regular.asFont(
                    weight = FontWeight.Normal,
                    style = FontStyle.Normal
                ),
            )
        )
}