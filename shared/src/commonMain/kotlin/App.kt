import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.moriatsushi.insetsx.SystemBarsBehavior
import com.moriatsushi.insetsx.rememberWindowInsetsController
import data.models.preferences.ThemePreference
import data.network.provideEngine
import data.storage.PreferenceStorage
import di.createDependencyInjector
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.httpFetcher
import io.kamel.core.config.takeFrom
import io.kamel.image.config.Default
import io.kamel.image.config.LocalKamelConfig
import org.kodein.di.compose.rememberInstance
import org.kodein.di.compose.withDI
import ui.screens.MainScreen
import ui.theme.MyColors
import ui.theme.MyTheme

@Composable
fun App() = withDI(createDependencyInjector()) {
    val preferences by rememberInstance<PreferenceStorage>()
    val windowInsetsController = rememberWindowInsetsController()
    val theme by preferences.theme.collectAsState(null)
    val isInDarkTheme = isSystemInDarkTheme()
    val kamelConfig = remember {
        KamelConfig {
            takeFrom(KamelConfig.Default)
            httpFetcher(provideEngine())
        }
    }

    // Update locale
    LaunchedEffect(Unit) {
        preferences.language.collect { value ->
            value?.locale
//            StringDesc.localeType = value?.locale?.let { locale ->
//                StringDesc.LocaleType.Custom(locale)
//            } ?: StringDesc.LocaleType.System
        }
    }
    // Update theme
    LaunchedEffect(theme, isInDarkTheme) {
        val useDarkIcons = when (theme) {
            ThemePreference.LIGHT -> true
            ThemePreference.DARK -> false
            else -> !isInDarkTheme
        }
        // The status bars icon + content will change to a light color
        windowInsetsController?.setStatusBarContentColor(dark = useDarkIcons)
        // The navigation bars icons will change to a light color (android only)
        windowInsetsController?.setNavigationBarsContentColor(dark = useDarkIcons)
        // Make system bars immersive
        windowInsetsController?.setSystemBarsBehavior(SystemBarsBehavior.Immersive)
    }

    CompositionLocalProvider(LocalKamelConfig provides kamelConfig) {
        // Initialize view
        theme?.let {
            MyTheme(
                colors = when (it) {
                    ThemePreference.SYSTEM -> when (isSystemInDarkTheme()) {
                        true -> MyColors.dark
                        else -> MyColors.light
                    }

                    ThemePreference.LIGHT -> MyColors.light
                    ThemePreference.DARK -> MyColors.dark
                }
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MyTheme.colors.background,
                    contentColor = MyTheme.colors.primary,
                ) {
                    MainScreen()
                }
            }
        }
    }
}
