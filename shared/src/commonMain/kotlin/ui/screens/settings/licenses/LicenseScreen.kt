package ui.screens.settings.licenses

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Popup
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.entity.Library
import com.moriatsushi.insetsx.statusBars
import ui.library.text.MyText
import ui.library.topbar.MyTopBar
import ui.resources.loadLicences
import ui.screens.settings.licenses.component.LicenseRow
import ui.theme.MyTheme

class LicenseScreen : Screen {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val licenceJson = loadLicences()
        val libs = remember {
            Libs.Builder()
                .withJson(licenceJson) // provide the metaData (alternative APIs available)
                .build()
        }

        var selection by mutableStateOf<Library?>(null)

        if (selection != null) {
            Popup(onDismissRequest = {
                selection = null
            }) {
                Column(
                    modifier = Modifier.background(MyTheme.colors.surface).fillMaxWidth()
                ) {
                    MyText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(MyTheme.dimensions.contentPadding),
                        style = MyTheme.typography.subTitle,
                        text = selection!!.name,
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars),
        ) {
            MyTopBar(
                content = {
                    MyText(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Licences",
                        style = MyTheme.typography.title
                    )
                }
            ) {
                navigator.pop()
            }
            LazyColumn(modifier = Modifier.weight(1F).fillMaxWidth()) {
                items(libs.libraries, key = { it.uniqueId }) { library ->
                    LicenseRow(
                        modifier = Modifier.fillMaxWidth(),
                        library = library,
                    ) {
                        selection = library
                    }
                }
                item("bottom-spacer") { Spacer(modifier = Modifier.height(MyTheme.dimensions.contentPadding)) }
            }
        }
    }
}