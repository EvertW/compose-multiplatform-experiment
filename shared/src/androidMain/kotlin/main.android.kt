import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import data.storage.PreferenceStorage
import data.storage.dataStore

@Composable
fun MainView(context: Context) {
    val preferences = remember { PreferenceStorage(dataStore(context)) }
    App(preferences = preferences)
}

actual fun getPlatformName(): String = "Android"
