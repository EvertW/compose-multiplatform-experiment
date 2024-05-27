package ui.screens.settings

import AppConfig
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
import com.evertwoud.multiplatform.resources.*
import com.moriatsushi.insetsx.statusBars
import data.models.preferences.LanguagePreference
import data.models.preferences.ThemePreference
import org.jetbrains.compose.resources.stringResource
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
                        text = stringResource(Res.string.settings_theme_selection),
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
                            text = theme.label,
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
                        text = stringResource(Res.string.settings_language_selection),
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
                            text = language.label,
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
                text = stringResource(Res.string.settings_title),
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
                text = stringResource(Res.string.settings_appearance),
                style = MyTheme.typography.subTitle
            )
            Spacer(modifier = Modifier.height(8.dp))
            SettingsRow(
                label = stringResource(Res.string.settings_language),
                onClick = {
                    screenModel.showLanguageDialog = true
                },
            )
            SettingsRow(
                label = stringResource(Res.string.settings_theme),
                onClick = {
                    screenModel.showThemeDialog = true
                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyText(
                modifier = Modifier.padding(horizontal = MyTheme.dimensions.contentPadding),
                text = stringResource(Res.string.settings_other),
                style = MyTheme.typography.subTitle
            )
            Spacer(modifier = Modifier.height(8.dp))
            SettingsRow(
                label = stringResource(Res.string.settings_licenses),
                onClick = {
                    navigator.push(LicenseScreen())
                },
            )
            SettingsRow(
                label = stringResource(Res.string.settings_report_issue),
                onClick = {
                    navigator.push(ReportIssueScreen())
                },
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MyTheme.dimensions.contentPadding),
                text = stringResource(Res.string.settings_version, AppConfig.APP_VERSION),
                style = MyTheme.typography.label.copy(textAlign = TextAlign.Center),
            )
        }
    }
}