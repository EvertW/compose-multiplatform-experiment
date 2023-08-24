package data.models.preferences

import androidx.compose.runtime.Composable
import com.evertwoud.multiplatform.example.MR

enum class ThemePreference() {
    DARK,
    LIGHT;

    val label
        @Composable
        get() = when (this) {
            DARK -> MR.strings.settings_theme_dark
            LIGHT -> MR.strings.settings_theme_light
        }
}