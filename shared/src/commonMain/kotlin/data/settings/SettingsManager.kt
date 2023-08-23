package data.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ui.theme.MyThemeSetting

class SettingsManager {

    var theme by mutableStateOf(MyThemeSetting.DARK)

}