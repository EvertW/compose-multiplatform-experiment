import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.moriatsushi.insetsx.SystemBarsBehavior
import com.moriatsushi.insetsx.rememberWindowInsetsController
import di.DependencyInjector
import org.kodein.di.compose.withDI
import ui.screens.MainScreen
import ui.theme.MyTheme

@Composable
fun App() = withDI(DependencyInjector) {
    val windowInsetsController = rememberWindowInsetsController()
    LaunchedEffect(Unit) {
        // The status bars icon + content will change to a light color
        windowInsetsController?.setStatusBarContentColor(dark = false)
        // The navigation bars icons will change to a light color (android only)
        windowInsetsController?.setNavigationBarsContentColor(dark = false)
        // Make system bars immersive
        windowInsetsController?.setSystemBarsBehavior(SystemBarsBehavior.Immersive)
    }

    MyTheme {
        MainScreen()
    }
}

expect fun getPlatformName(): String
fun getAppVersion() = "1.0"