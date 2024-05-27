package data.models.preferences

import androidx.compose.runtime.Composable
import com.evertwoud.multiplatform.resources.Res
import com.evertwoud.multiplatform.resources.settings_theme_dark
import com.evertwoud.multiplatform.resources.settings_theme_light
import com.evertwoud.multiplatform.resources.settings_theme_system
import org.jetbrains.compose.resources.stringResource

enum class ThemePreference {
    SYSTEM,
    DARK,
    LIGHT;

    val label
        @Composable
        get() = stringResource(
            when (this) {
                SYSTEM -> Res.string.settings_theme_system
                DARK -> Res.string.settings_theme_dark
                LIGHT -> Res.string.settings_theme_light
            }
        )
}