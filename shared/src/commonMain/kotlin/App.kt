import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.library.buttons.MyButton
import ui.library.buttons.MyButtonStyle
import ui.library.text.MyText
import ui.theme.MyTheme
import ui.MainScreen

@Composable
fun App() {
    MyTheme {
        MainScreen()
    }
}

expect fun getPlatformName(): String