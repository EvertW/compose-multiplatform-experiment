package data.models.preferences

import androidx.compose.runtime.Composable
import com.evertwoud.multiplatform.resources.Res
import com.evertwoud.multiplatform.resources.settings_language_en
import com.evertwoud.multiplatform.resources.settings_language_nl
import org.jetbrains.compose.resources.stringResource

enum class LanguagePreference(val locale: String?) {
    EN(locale = "en"),
    NL(locale = "nl");

    val label
        @Composable
        get() = stringResource(
            when (this) {
                EN -> Res.string.settings_language_en
                NL -> Res.string.settings_language_nl
            }
        )
}

