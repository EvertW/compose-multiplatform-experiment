import android.content.Context
import androidx.compose.runtime.Composable
import data.storage.PreferenceStorage
import data.storage.dataStore

@Composable
fun MainView(context: Context) {
    App(preferences = PreferenceStorage(dataStore(context)))
}

actual fun getPlatformName(): String = "Android"
