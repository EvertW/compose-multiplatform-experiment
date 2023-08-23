package ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import com.moriatsushi.insetsx.statusBars
import getAppVersion
import ui.library.text.MyText
import ui.screens.settings.component.SettingsRow
import ui.theme.MyTheme

object SettingsScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel<SettingsScreenModel>()
        val scrollState = rememberScrollState()

        LaunchedEffect(screenModel) {
            screenModel.init()
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(vertical = MyTheme.dimensions.contentPadding)
                .windowInsetsPadding(WindowInsets.statusBars),
        ) {
            MyText(
                modifier = Modifier.padding(horizontal = MyTheme.dimensions.contentPadding),
                text = "Settings",
                style = MyTheme.typography.title
            )
            Spacer(modifier = Modifier.height(4.dp))
            MyText(
                modifier = Modifier.padding(horizontal = MyTheme.dimensions.contentPadding),
                text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyText(
                modifier = Modifier.padding(horizontal = MyTheme.dimensions.contentPadding),
                text = "Appearance",
                style = MyTheme.typography.subTitle
            )
            Spacer(modifier = Modifier.height(8.dp))
            SettingsRow(
                label = "Language",
                onClick = {

                },
            )
            SettingsRow(
                label = "Theme",
                onClick = {

                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyText(
                modifier = Modifier.padding(horizontal = MyTheme.dimensions.contentPadding),
                text = "Other",
                style = MyTheme.typography.subTitle
            )
            Spacer(modifier = Modifier.height(8.dp))
            SettingsRow(
                label = "Terms & conditions",
                onClick = {

                },
            )
            SettingsRow(
                label = "Licences",
                onClick = {

                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MyTheme.dimensions.contentPadding),
                text = "Version: ${getAppVersion()}",
                style = MyTheme.typography.label.copy(textAlign = TextAlign.Center),
            )
        }
    }
}