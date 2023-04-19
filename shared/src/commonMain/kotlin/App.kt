import androidx.compose.runtime.Composable
import ui.theme.MyTheme
import ui.screens.MainScreen

@Composable
fun App() {
    MyTheme {
        MainScreen()
    }
}

expect fun getPlatformName(): String