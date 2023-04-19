package ui.screens

import moe.tlaster.precompose.navigation.RouteBuilder
import ui.screens.home.HomeScreen
import ui.screens.settings.SettingsScreen


sealed class NavDestination(val route: String) {
    object Home : NavDestination("home")
    object Settings : NavDestination("settings")
}

fun RouteBuilder.buildMainNavigation() {
    scene(NavDestination.Home.route) {
        HomeScreen()
    }
    scene(NavDestination.Settings.route) {
        SettingsScreen()
    }
}