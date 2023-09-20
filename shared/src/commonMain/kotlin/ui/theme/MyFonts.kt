package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.evertwoud.multiplatform.example.MR
import dev.icerock.moko.resources.compose.asFont

internal object MyFonts {
    val Poppins
        @Composable
        get() = FontFamily(
            listOfNotNull(
                MR.fonts.poppins.bold.asFont(
                    weight = FontWeight.Bold,
                    style = FontStyle.Normal
                ),
                MR.fonts.poppins.medium.asFont(
                    weight = FontWeight.Medium,
                    style = FontStyle.Normal
                ),
                MR.fonts.poppins.semibold.asFont(
                    weight = FontWeight.SemiBold,
                    style = FontStyle.Normal
                ),
                MR.fonts.poppins.regular.asFont(
                    weight = FontWeight.Normal,
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