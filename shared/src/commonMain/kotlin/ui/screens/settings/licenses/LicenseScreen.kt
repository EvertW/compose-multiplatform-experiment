package ui.screens.settings.licenses

import LicenseScreenModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.evertwoud.multiplatform.example.MR
import com.moriatsushi.insetsx.safeArea
import data.api.state.NetworkDataState
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.compose.readTextAsState
import dev.icerock.moko.resources.desc.desc
import ui.library.error.MyErrorStateComponent
import ui.library.loading.MyLoadingIndicator
import ui.library.text.MyText
import ui.library.topbar.MyTopBar
import ui.screens.settings.licenses.component.LicenseRow
import ui.screens.settings.licenses.detail.LicenseDetailScreen
import ui.theme.MyTheme

class LicenseScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel<LicenseScreenModel>()
        val navigator = LocalNavigator.currentOrThrow
        val licenseJson by MR.assets.aboutlibraries.readTextAsState()

        LaunchedEffect(licenseJson) {
            licenseJson?.let { json -> screenModel.load(json) }
        }

        Column(
            modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeArea),
        ) {
            MyTopBar {
                navigator.pop()
            }
            LazyColumn(modifier = Modifier.weight(1F).fillMaxWidth()) {
                item("licence-header") {
                    MyText(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = MyTheme.dimensions.contentPadding),
                        text = MR.strings.settings_licenses.desc().localized(),
                        style = MyTheme.typography.title
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
                when (val state = screenModel.libs) {
                    is NetworkDataState.Error -> item("error") {
                        MyErrorStateComponent(
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = MyTheme.dimensions.contentPadding),
                        )
                    }

                    is NetworkDataState.Success -> items(items = state.data.libraries,
                        key = { it.uniqueId }) { library ->
                        LicenseRow(
                            modifier = Modifier.fillMaxWidth(),
                            library = library,
                        ) {
                            navigator.push(LicenseDetailScreen(library))
                        }
                    }

                    else -> item("loader") {
                        MyLoadingIndicator(
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = MyTheme.dimensions.contentPadding)
                        )
                    }
                }

                item("bottom-spacer") { Spacer(modifier = Modifier.height(MyTheme.dimensions.contentPadding)) }
            }
        }
    }
}