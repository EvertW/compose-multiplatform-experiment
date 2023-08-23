package ui.screens.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import data.api.NetworkClient
import data.settings.SettingsManager

class SettingsScreenModel(
    private val api: NetworkClient,
    val settings: SettingsManager,
) : ScreenModel {

    var showThemeDialog by mutableStateOf(false)

    fun init() {
    }
}