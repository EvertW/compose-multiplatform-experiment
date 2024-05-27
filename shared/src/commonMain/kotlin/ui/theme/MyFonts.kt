package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.evertwoud.multiplatform.resources.*
import org.jetbrains.compose.resources.Font

internal object MyFonts {
    val Poppins
        @Composable
        get() = FontFamily(
            listOfNotNull(
                Font(Res.font.poppins_bold, FontWeight.Bold, FontStyle.Normal),
                Font(Res.font.poppins_medium, FontWeight.Medium, FontStyle.Normal),
                Font(Res.font.poppins_semibold, FontWeight.SemiBold, FontStyle.Normal),
                Font(Res.font.poppins_regular, FontWeight.Normal, FontStyle.Normal),
            )
        )

    val DmSans
        @Composable
        get() = FontFamily(
            listOfNotNull(
                Font(Res.font.dmsans_bold, FontWeight.Bold, FontStyle.Normal),
                Font(Res.font.dmsans_medium, FontWeight.Medium, FontStyle.Normal),
                Font(Res.font.dmsans_regular, FontWeight.Normal, FontStyle.Normal),
            )
        )
}