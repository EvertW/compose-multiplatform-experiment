import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.moriatsushi.insetsx.SystemBarsBehavior
import com.moriatsushi.insetsx.rememberWindowInsetsController
import data.storage.PreferenceStorage
import di.createDependencyInjector
import org.kodein.di.compose.withDI
import ui.screens.MainScreen
import ui.theme.MyColorsDark
import ui.theme.MyColorsLight
import ui.theme.MyTheme
import ui.theme.MyThemeSetting

@Composable
fun App(preferences: PreferenceStorage) = withDI(createDependencyInjector(preferences)) {
    val windowInsetsController = rememberWindowInsetsController()
    val theme by preferences.theme.collectAsState(null)

    LaunchedEffect(theme) {
        // The status bars icon + content will change to a light color
        windowInsetsController?.setStatusBarContentColor(
            dark = when (theme) {
                MyThemeSetting.LIGHT -> true
                else -> false
            }
        )
        // The navigation bars icons will change to a light color (android only)
        windowInsetsController?.setNavigationBarsContentColor(
            dark = when (theme) {
                MyThemeSetting.LIGHT -> true
                else -> false
            }
        )
        // Make system bars immersive
        windowInsetsController?.setSystemBarsBehavior(SystemBarsBehavior.Immersive)
    }

    theme?.let {
        MyTheme(
            colors = when (it) {
                MyThemeSetting.LIGHT -> MyColorsLight()
                MyThemeSetting.DARK -> MyColorsDark()
            }
        ) {
            MainScreen()
        }
    }
}

expect fun getPlatformName(): String
fun getAppVersion() = "1.0"