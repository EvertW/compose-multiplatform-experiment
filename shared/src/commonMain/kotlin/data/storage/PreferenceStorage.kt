package data.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import okio.Path.Companion.toPath
import ui.theme.MyThemeSetting

class PreferenceStorage(
    private val store: DataStore<Preferences>,
) {
    companion object {
        private val THEME_KEY = stringPreferencesKey("theme")

        fun create(
            fileName: String = "preferences",
            path: (name: String) -> String,
        ): DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(
            corruptionHandler = null,
            migrations = emptyList(),
            produceFile = { path("$fileName.preferences_pb").toPath() },
        )
    }

    val theme = store.data.map { preferences ->
        MyThemeSetting.entries.firstOrNull {
            it.name == preferences[THEME_KEY]
        } ?: MyThemeSetting.DARK
    }

    suspend fun updateTheme(value: MyThemeSetting) = store.edit { preferences ->
        preferences[THEME_KEY] = value.name
    }
}