import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import compose.icons.FeatherIcons
import compose.icons.feathericons.Calendar
import compose.icons.feathericons.Home
import compose.icons.feathericons.Settings
import ui.library.menu.MyBottomMenu
import ui.library.menu.MyBottomMenuItem
import ui.screens.calendar.CalendarScreen
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
                content = {
                    Box(modifier = Modifier.padding(it).fillMaxSize()) {
                        CurrentScreen()
                    }
                },
                bottomBar = {
                    when (navigator.lastItem) {
                        is HomeScreen,
                        is SettingsScreen,
                        is CalendarScreen -> MyBottomMenu(modifier = Modifier.fillMaxWidth()) {
                            MyBottomMenuItem(
                                icon = FeatherIcons.Home,
                                contentDescription = "Home"
                            ) {
                                navigator.replace(HomeScreen)
                            }
                            MyBottomMenuItem(
                                icon = FeatherIcons.Calendar,
                                contentDescription = "Calendar"
                            ) {
                                navigator.replace(CalendarScreen)
                            }
                            MyBottomMenuItem(
                                icon = FeatherIcons.Settings,
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