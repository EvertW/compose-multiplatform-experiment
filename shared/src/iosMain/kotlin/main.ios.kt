import androidx.compose.ui.window.ComposeUIViewController
import data.storage.PreferenceStorage
import data.storage.dataStore

fun MainViewController() = ComposeUIViewController {
    App(
        preferences = PreferenceStorage(dataStore())
    )
}

actual fun getPlatformName(): String = "iOS"