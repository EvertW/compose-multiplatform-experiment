import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.moriatsushi.insetsx.ExperimentalSoftwareKeyboardApi
import com.moriatsushi.insetsx.SystemBarsBehavior
import com.moriatsushi.insetsx.ime
import com.moriatsushi.insetsx.navigationBars
import com.moriatsushi.insetsx.rememberWindowInsetsController
import compose.icons.TablerIcons
import compose.icons.tablericons.Globe
import compose.icons.tablericons.Home2
import compose.icons.tablericons.List
import compose.icons.tablericons.Settings
import ui.library.menu.MyBottomMenu
import ui.library.menu.MyBottomMenuItem
import ui.screens.home.HomeScreen
import ui.screens.trips.TripScreen
import ui.screens.settings.SettingsScreen
import ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSoftwareKeyboardApi::class)
@Composable
fun App() {
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
        Navigator(
            screen = HomeScreen
        ) { navigator ->
            Scaffold(
                modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.ime),
                containerColor = MyTheme.colors.background,
                contentColor = MyTheme.colors.primary,
                contentWindowInsets = WindowInsets(0.dp),
                content = {
                    Box(modifier = Modifier.padding(it).fillMaxSize()) {
                        CurrentScreen()
                    }
                },
                bottomBar = {
                    when (navigator.lastItem) {
                        is HomeScreen,
                        is SettingsScreen,
                        is TripScreen -> MyBottomMenu(
                            modifier = Modifier.fillMaxWidth()
                                .windowInsetsPadding(WindowInsets.navigationBars)
                        ) {
                            MyBottomMenuItem(
                                icon = TablerIcons.Home2,
                                contentDescription = "Home"
                            ) {
                                navigator.replace(HomeScreen)
                            }
                            MyBottomMenuItem(
                                icon = TablerIcons.Globe,
                                contentDescription = "Trips"
                            ) {
                                navigator.replace(TripScreen)
                            }
                            MyBottomMenuItem(
                                icon = TablerIcons.Settings,
                                contentDescription = "Settings"
                            ) {
                                navigator.replace(SettingsScreen)
                            }
                        }
                    }
                }
            )
        }
    }
}

expect fun getPlatformName(): String
fun getAppVersion() = "1.0"