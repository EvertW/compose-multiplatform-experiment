package ui.library.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import ui.theme.MyFonts
import ui.theme.MyTheme

@Composable
fun MyText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MyTheme.typography.body,
    font: FontFamily = when (style) {
        MyTheme.typography.title,
        MyTheme.typography.subTitle,
        MyTheme.typography.button,
        -> MyFonts.SpaceMono

        else -> MyFonts.DmSans
    }
) {
    Text(
        modifier = modifier,
        text = text,
        style = style.copy(
            fontFamily = font
        )
    )
}