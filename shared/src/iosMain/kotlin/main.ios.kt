import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import data.storage.PreferenceStorage
import data.storage.dataStore

fun MainViewController() = ComposeUIViewController {
    val preferences = remember { PreferenceStorage(dataStore()) }
    App(preferences = preferences)
}

actual fun getPlatformName(): String = "iOS"