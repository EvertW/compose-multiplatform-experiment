package ui.screens.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import data.models.preferences.LanguagePreference
import data.models.preferences.ThemePreference
import data.storage.PreferenceStorage
import kotlinx.coroutines.launch

class SettingsScreenModel(
    private val preferences: PreferenceStorage,
) : ScreenModel {

    var showThemeDialog by mutableStateOf(false)
    var showLanguageDialog by mutableStateOf(false)

    val theme = preferences.theme
    val language = preferences.language

    fun init() {
    }

    fun updateTheme(theme: ThemePreference) = coroutineScope.launch {
        preferences.updateTheme(theme)
    }

    fun updateLanguage(language: LanguagePreference) = coroutineScope.launch {
        preferences.updateLanguage(language)
    }
}