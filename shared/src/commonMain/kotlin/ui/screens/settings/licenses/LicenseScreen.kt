package ui.screens.settings.licenses

import LicenseScreenModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.evertwoud.multiplatform.example.MR
import com.moriatsushi.insetsx.safeArea
import dev.icerock.moko.resources.compose.readTextAsState
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
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeArea),
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
                items(screenModel.libs?.libraries.orEmpty(), key = { it.uniqueId }) { library ->
                    LicenseRow(
                        modifier = Modifier.fillMaxWidth(),
                        library = library,
                    ) {
                        navigator.push(LicenseDetailScreen(library))
                    }
                }
                item("bottom-spacer") { Spacer(modifier = Modifier.height(MyTheme.dimensions.contentPadding)) }
            }
        }
    }
}