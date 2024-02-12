package ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberNavigatorScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.evertwoud.multiplatform.example.MR
import com.moriatsushi.insetsx.statusBars
import data.models.preferences.LanguagePreference
import data.models.preferences.ThemePreference
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.resources.format
import getAppVersion
import ui.library.text.MyText
import ui.screens.settings.component.SettingsRow
import ui.screens.settings.issue.ReportIssueScreen
import ui.screens.settings.licenses.LicenseScreen
import ui.theme.MyTheme

object SettingsScreen : Screen {
    @Composable
    override fun Content() {
        val scrollState = rememberScrollState()
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = navigator.rememberNavigatorScreenModel<SettingsScreenModel>()

        LaunchedEffect(screenModel) {
            screenModel.init()
        }

        if (screenModel.showThemeDialog) {
            Dialog(onDismissRequest = {
                screenModel.showThemeDialog = false
            }) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(MyTheme.colors.surface)
                        .fillMaxWidth()
                ) {
                    MyText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(MyTheme.dimensions.contentPadding),
                        style = MyTheme.typography.subTitle,
                        text = MR.strings.settings_theme_selection.desc().localized(),
                    )
                    ThemePreference.entries.forEach { theme ->
                        MyText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    screenModel.updateTheme(theme)
                                }
                                .padding(MyTheme.dimensions.contentPadding),
                            style = MyTheme.typography.listItem,
                            color = when (screenModel.theme.collectAsState(null).value == theme) {
                                true -> MyTheme.colors.primary
                                false -> MyTheme.colors.text
                            },
                            text = theme.label.desc().localized(),
                        )
                    }
                }
            }
        }

        if (screenModel.showLanguageDialog) {
            Dialog(onDismissRequest = {
                screenModel.showLanguageDialog = false
            }) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(MyTheme.colors.surface)
                        .fillMaxWidth()
                ) {
                    MyText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(MyTheme.dimensions.contentPadding),
                        style = MyTheme.typography.subTitle,
                        text = MR.strings.settings_language_selection.desc().localized(),
                    )
                    LanguagePreference.entries.forEach { language ->
                        MyText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    screenModel.updateLanguage(language)
                                }
                                .padding(MyTheme.dimensions.contentPadding),
                            style = MyTheme.typography.listItem,
                            color = when (screenModel.language.collectAsState(null).value) {
                                language -> MyTheme.colors.primary
                                else -> MyTheme.colors.text
                            },
                            text = language.label.desc().localized(),
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars)
                .verticalScroll(scrollState)
                .padding(vertical = MyTheme.dimensions.contentPadding),
        ) {
            MyText(
                modifier = Modifier.padding(horizontal = MyTheme.dimensions.contentPadding),
                text = MR.strings.settings_title.desc().localized(),
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
                text = MR.strings.settings_appearance.desc().localized(),
                style = MyTheme.typography.subTitle
            )
            Spacer(modifier = Modifier.height(8.dp))
            SettingsRow(
                label = MR.strings.settings_language.desc().localized(),
                onClick = {
                    screenModel.showLanguageDialog = true
                },
            )
            SettingsRow(
                label = MR.strings.settings_theme.desc().localized(),
                onClick = {
                    screenModel.showThemeDialog = true
                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyText(
                modifier = Modifier.padding(horizontal = MyTheme.dimensions.contentPadding),
                text = MR.strings.settings_other.desc().localized(),
                style = MyTheme.typography.subTitle
            )
            Spacer(modifier = Modifier.height(8.dp))
            SettingsRow(
                label = MR.strings.settings_licenses.desc().localized(),
                onClick = {
                    navigator.push(LicenseScreen())
                },
            )
            SettingsRow(
                label = MR.strings.settings_report_issue.desc().localized(),
                onClick = {
                    navigator.push(ReportIssueScreen())
                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MyTheme.dimensions.contentPadding),
                text = MR.strings.settings_version.format(getAppVersion()).localized(),
                style = MyTheme.typography.label.copy(textAlign = TextAlign.Center),
            )
        }
    }
}