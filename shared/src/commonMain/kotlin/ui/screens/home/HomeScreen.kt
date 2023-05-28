package ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.moriatsushi.insetsx.statusBars
import compose.icons.FeatherIcons
import compose.icons.feathericons.ExternalLink
import ui.library.buttons.MyButton
import ui.library.buttons.MyButtonStyle
import ui.library.text.MyText
import ui.screens.detail.DetailScreen
import ui.theme.MyTheme

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val uriHandler = LocalUriHandler.current
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
                .padding(MyTheme.dimensions.contentPadding)
                .windowInsetsPadding(WindowInsets.statusBars),
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(MyTheme.colors.primary),
                contentAlignment = Alignment.Center
            ) {
                MyText(
                    text = "mpe",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        lineHeight = 22.sp,
                    ),
                    color = MyTheme.colors.textInverse
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            MyText(
                text = "Multiplatform Experiment", style = MyTheme.typography.subTitle
            )
            Spacer(modifier = Modifier.height(8.dp))
            MyText(
                text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                MyButton(
                    text = "Open detail",
                ) {
                    navigator.push(DetailScreen())
                }
                MyButton(
                    text = "More info",
                    icon = FeatherIcons.ExternalLink,
                    style = MyButtonStyle.Secondary
                ) {
                    uriHandler.openUri("https://www.evertwoud.com")
                }
            }
        }
    }
}