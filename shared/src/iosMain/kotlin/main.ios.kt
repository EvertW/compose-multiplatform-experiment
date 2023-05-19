import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { App() }
actual fun getPlatformName(): String = "iOS"