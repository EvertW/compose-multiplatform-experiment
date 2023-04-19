import androidx.compose.runtime.Composable
import ui.screens.MainScreen
import ui.theme.MyTheme

@Composable
fun App() {
    MyTheme {
        MainScreen()
    }
}

expect fun getPlatformName(): String