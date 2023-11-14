package ui.screens.settings.licenses.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mikepenz.aboutlibraries.entity.Library
import com.moriatsushi.insetsx.safeArea
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowUpRight
import ui.library.buttons.MyButton
import ui.library.buttons.MyButtonStyle
import ui.library.text.MyText
import ui.library.topbar.MyTopBar
import ui.theme.MyTheme

class LicenseDetailScreen(
    val library: Library
) : Screen {
    @Composable
    override fun Content() {
        val uriHandler = LocalUriHandler.current
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeArea),
        ) {
            MyTopBar {
                navigator.pop()
            }
            Column(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(MyTheme.dimensions.contentPadding)
            ) {
                MyText(
                    modifier = Modifier.fillMaxWidth(),
                    text = library.organization?.name ?: library.developers.joinToString(", ") {
                        it.name.orEmpty()
                    },
                    style = MyTheme.typography.label
                )
                Spacer(modifier = Modifier.height(4.dp))
                MyText(
                    modifier = Modifier.fillMaxWidth(),
                    text = library.name,
                    style = MyTheme.typography.title
                )
                Spacer(modifier = Modifier.height(4.dp))
                MyText(
                    modifier = Modifier.background(MyTheme.colors.primary, CircleShape)
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                    text = library.artifactVersion.orEmpty(),
                    color = MyTheme.colors.textInverse,
                    style = MyTheme.typography.label
                )
                Spacer(modifier = Modifier.height(16.dp))
                library.description?.let { description ->
                    MyText(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Description",
                        style = MyTheme.typography.subTitle
                    )
                    MyText(
                        modifier = Modifier.fillMaxWidth(),
                        text = description,
                        style = MyTheme.typography.body
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
                Row {
                    library.organization?.url?.let { website ->
                        MyButton(
                            text = "Organization",
                            icon = TablerIcons.ArrowUpRight,
                            style = MyButtonStyle.Primary
                        ) {
                            uriHandler.openUri(website)
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                    library.website?.let { website ->
                        MyButton(
                            text = "Website",
                            icon = TablerIcons.ArrowUpRight,
                            style = MyButtonStyle.Secondary
                        ) {
                            uriHandler.openUri(website)
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
                library.licenses.forEach { license ->
                    Spacer(modifier = Modifier.height(24.dp))
                    MyText(
                        modifier = Modifier.fillMaxWidth(),
                        text = license.name,
                        style = MyTheme.typography.subTitle
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    MyText(
                        modifier = Modifier.fillMaxWidth(),
                        text = license.licenseContent.orEmpty(),
                        style = MyTheme.typography.body
                    )
                }
            }
        }
    }
}