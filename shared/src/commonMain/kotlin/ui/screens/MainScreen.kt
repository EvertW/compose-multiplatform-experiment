package ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.moriatsushi.insetsx.ime
import com.moriatsushi.insetsx.navigationBars
import compose.icons.TablerIcons
import compose.icons.tablericons.BuildingWarehouse
import compose.icons.tablericons.Home2
import compose.icons.tablericons.List
import compose.icons.tablericons.Settings
import compose.icons.tablericons.ShoppingCart
import ui.library.menu.MyBottomMenu
import ui.library.menu.MyBottomMenuItem
import ui.screens.breeds.BreedScreen
import ui.screens.home.HomeScreen
import ui.screens.settings.SettingsScreen
import ui.theme.MyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
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
                    is BreedScreen-> MyBottomMenu(
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
                            icon = TablerIcons.List,
                            contentDescription = "Breeds"
                        ) {
                            navigator.replace(BreedScreen)
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