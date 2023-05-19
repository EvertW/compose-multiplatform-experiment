import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import ui.library.menu.MyBottomMenu
import ui.library.menu.MyBottomMenuItem
import ui.screens.home.HomeScreen
import ui.screens.settings.SettingsScreen
import ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MyTheme {
        Navigator(
            screen = HomeScreen
        ) { navigator ->
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = MyTheme.colors.background,
                contentColor = MyTheme.colors.primary,
                content = { CurrentScreen() },
                bottomBar = {
                    if (navigator.lastItem is HomeScreen || navigator.lastItem is SettingsScreen) {
                        MyBottomMenu(modifier = Modifier.fillMaxWidth()) {
                            MyBottomMenuItem(
                                icon = Icons.Outlined.Home,
                                contentDescription = "Home"
                            ) {
                                navigator.replace(HomeScreen)
                            }
                            MyBottomMenuItem(
                                icon = Icons.Outlined.Settings,
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