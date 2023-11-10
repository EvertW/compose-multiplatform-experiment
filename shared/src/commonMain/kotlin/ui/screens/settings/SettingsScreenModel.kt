package ui.screens.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.model.screenModelScope
import data.models.preferences.LanguagePreference
import data.models.preferences.ThemePreference
import data.storage.PreferenceStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
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

    fun updateTheme(theme: ThemePreference) = screenModelScope.launch(Dispatchers.IO) {
        preferences.updateTheme(theme)
    }

    fun updateLanguage(language: LanguagePreference) = screenModelScope.launch(Dispatchers.IO) {
        preferences.updateLanguage(language)
    }
}