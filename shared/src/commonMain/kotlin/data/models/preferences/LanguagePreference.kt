package data.models.preferences

import androidx.compose.runtime.Composable
import com.evertwoud.multiplatform.example.MR

enum class LanguagePreference(val locale: String?) {
    EN(locale = "en"),
    NL(locale = "nl");

    val label
        @Composable
        get() = when (this) {
            EN -> MR.strings.settings_language_en
            NL -> MR.strings.settings_language_nl
        }
}

