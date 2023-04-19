package ui.screens

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.PopUpTo
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import ui.library.menu.MyBottomMenu
import ui.library.menu.MyBottomMenuItem

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val navigator = rememberNavigator()

    Column(modifier = modifier.fillMaxSize()) {
        NavHost(
            modifier = modifier.weight(1F),
            navigator = navigator,
            navTransition = remember {
                NavTransition(
                    createTransition = fadeIn(),
                    destroyTransition = fadeOut(),
                    resumeTransition = fadeIn(),
                    pauseTransition = fadeOut(),
                )
            },
            initialRoute = NavDestination.Home.route,
            builder = { this.buildMainNavigation() }
        )
        MyBottomMenu(modifier = Modifier.fillMaxWidth()) {
            MyBottomMenuItem(
                icon = Icons.Outlined.Home,
                contentDescription = "Home"
            ) {
                navigator.navigate(
                    route = NavDestination.Home.route,
                    options = NavOptions(
                        launchSingleTop = true,
                        popUpTo = PopUpTo(NavDestination.Home.route, false),
                    )
                )
            }
            MyBottomMenuItem(
                icon = Icons.Outlined.Settings,
                contentDescription = "Settings"
            ) {
                navigator.navigate(
                    route = NavDestination.Settings.route,
                    options = NavOptions(
                        launchSingleTop = true,
                        popUpTo = PopUpTo(NavDestination.Home.route, false),
                    )
                )
            }
        }
    }
}

