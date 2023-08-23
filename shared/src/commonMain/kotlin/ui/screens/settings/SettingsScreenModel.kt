package ui.screens.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import data.api.NetworkClient
import data.storage.PreferenceStorage
import kotlinx.coroutines.launch
import ui.theme.MyThemeSetting

class SettingsScreenModel(
    private val api: NetworkClient,
    private val preferences: PreferenceStorage,
) : ScreenModel {

    var showThemeDialog by mutableStateOf(false)

    val theme = preferences.theme

    fun init() {
    }

    fun updateTheme(theme: MyThemeSetting) = coroutineScope.launch {
        preferences.updateTheme(theme)
    }
}