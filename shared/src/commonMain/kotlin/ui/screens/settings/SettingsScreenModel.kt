package ui.screens.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import data.api.NetworkClient
import ui.theme.MyThemeOption

class SettingsScreenModel(
    private val api: NetworkClient
) : ScreenModel {

    var theme by mutableStateOf(MyThemeOption.SYSTEM)
        private set

    fun init() {
    }
}