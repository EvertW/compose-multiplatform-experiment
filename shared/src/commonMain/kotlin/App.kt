import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.moriatsushi.insetsx.SystemBarsBehavior
import com.moriatsushi.insetsx.rememberWindowInsetsController
import data.models.preferences.ThemePreference
import data.storage.PreferenceStorage
import dev.icerock.moko.resources.desc.StringDesc
import di.createDependencyInjector
import org.kodein.di.compose.withDI
import ui.screens.MainScreen
import ui.theme.MyColors
import ui.theme.MyTheme

@Composable
fun App(preferences: PreferenceStorage) = withDI(createDependencyInjector(preferences)) {
    val windowInsetsController = rememberWindowInsetsController()
    val theme by preferences.theme.collectAsState(null)
    // Update locale
    LaunchedEffect(Unit) {
        preferences.language.collect { value ->
            StringDesc.localeType = value?.locale?.let { locale ->
                StringDesc.LocaleType.Custom(locale)
            } ?: StringDesc.LocaleType.System
        }
    }
    // Update theme
    LaunchedEffect(theme) {
        // The status bars icon + content will change to a light color
        windowInsetsController?.setStatusBarContentColor(
            dark = when (theme) {
                ThemePreference.LIGHT -> true
                else -> false
            }
        )
        // The navigation bars icons will change to a light color (android only)
        windowInsetsController?.setNavigationBarsContentColor(
            dark = when (theme) {
                ThemePreference.LIGHT -> true
                else -> false
            }
        )
        // Make system bars immersive
        windowInsetsController?.setSystemBarsBehavior(SystemBarsBehavior.Immersive)
    }
    // Initialize view
    theme?.let {
        MyTheme(
            colors = when (it) {
                ThemePreference.LIGHT -> MyColors.light
                ThemePreference.DARK -> MyColors.dark
            }
        ) {
            MainScreen()
        }
    }
}

expect fun getPlatformName(): String
fun getAppVersion() = "1.0"