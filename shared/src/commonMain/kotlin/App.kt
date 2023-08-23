import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.moriatsushi.insetsx.SystemBarsBehavior
import com.moriatsushi.insetsx.rememberWindowInsetsController
import data.settings.SettingsManager
import di.DependencyInjector
import org.kodein.di.compose.localDI
import org.kodein.di.compose.withDI
import org.kodein.di.instance
import ui.screens.MainScreen
import ui.theme.MyColorsDark
import ui.theme.MyColorsLight
import ui.theme.MyTheme
import ui.theme.MyThemeSetting

@Composable
fun App() = withDI(DependencyInjector) {
    val di = localDI()
    val settingsManager by di.instance<SettingsManager>()
    val windowInsetsController = rememberWindowInsetsController()

    LaunchedEffect(settingsManager.theme) {
        // The status bars icon + content will change to a light color
        windowInsetsController?.setStatusBarContentColor(
            dark = when (settingsManager.theme) {
                MyThemeSetting.LIGHT -> true
                MyThemeSetting.DARK -> false
            }
        )
        // The navigation bars icons will change to a light color (android only)
        windowInsetsController?.setNavigationBarsContentColor(
            dark = when (settingsManager.theme) {
                MyThemeSetting.LIGHT -> true
                MyThemeSetting.DARK -> false
            }
        )
        // Make system bars immersive
        windowInsetsController?.setSystemBarsBehavior(SystemBarsBehavior.Immersive)
    }

    val colors = when (settingsManager.theme) {
        MyThemeSetting.LIGHT -> MyColorsLight()
        MyThemeSetting.DARK -> MyColorsDark()
    }

    MyTheme(
        colors = colors
    ) {
        MainScreen()
    }
}

expect fun getPlatformName(): String
fun getAppVersion() = "1.0"