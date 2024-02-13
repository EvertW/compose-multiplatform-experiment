package data.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import data.models.preferences.LanguagePreference
import data.models.preferences.ThemePreference
import kotlinx.coroutines.flow.map
import okio.Path.Companion.toPath

class PreferenceStorage(
    private val store: DataStore<Preferences>,
) {
    companion object {
        private val THEME_KEY = stringPreferencesKey("theme")
        private val LANGUAGE_KEY = stringPreferencesKey("language")

        fun create(
            fileName: String = "preferences",
            path: (name: String) -> String,
        ): PreferenceStorage = PreferenceStorage(
            PreferenceDataStoreFactory.createWithPath(
                corruptionHandler = null,
                migrations = emptyList(),
                produceFile = { path("$fileName.preferences_pb").toPath() },
            )
        )
    }

    /**
     * Theme
     */
    val theme = store.data.map { preferences ->
        ThemePreference.entries.firstOrNull {
            it.name == preferences[THEME_KEY]
        } ?: ThemePreference.SYSTEM
    }

    suspend fun updateTheme(value: ThemePreference) = store.edit { preferences ->
        preferences[THEME_KEY] = value.name
    }

    /**
     * Language
     */
    val language = store.data.map { preferences ->
        LanguagePreference.entries.firstOrNull {
            it.name == preferences[LANGUAGE_KEY]
        }
    }

    suspend fun updateLanguage(value: LanguagePreference) = store.edit { preferences ->
        preferences[LANGUAGE_KEY] = value.name
    }
}