package ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ui.library.menu.MyBottomMenu
import ui.library.menu.MyBottomMenuItem
import ui.screens.settings.SettingsScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val content = @Composable { modifier: Modifier ->
        when (Navigation.route) {
            NavRoute.Home -> HomeScreen(modifier = modifier)
            NavRoute.Settings -> SettingsScreen(modifier = modifier)
        }
    }
    Column(modifier = modifier.fillMaxSize()) {
        content.invoke(Modifier.weight(1F))
        MyBottomMenu(modifier = Modifier.fillMaxWidth()) {
            MyBottomMenuItem(
                icon = Icons.Outlined.Home,
                contentDescription = "Home"
            ) { Navigation.route = NavRoute.Home }
            MyBottomMenuItem(
                icon = Icons.Outlined.Settings,
                contentDescription = "Settings"
            ) { Navigation.route = NavRoute.Settings }
        }
    }
}

object Navigation {
    var route by mutableStateOf<NavRoute>(NavRoute.Home)
}

sealed class NavRoute {
    object Home : NavRoute()
    object Settings : NavRoute()
}