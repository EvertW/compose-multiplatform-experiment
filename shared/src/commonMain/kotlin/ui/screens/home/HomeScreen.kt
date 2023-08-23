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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.moriatsushi.insetsx.statusBars
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowUpRight
import ui.library.banner.MyBanner
import ui.library.buttons.MyButton
import ui.library.buttons.MyButtonStyle
import ui.library.text.MyText
import ui.theme.MyTheme

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
                .windowInsetsPadding(WindowInsets.statusBars),
        ) {
            Column(modifier = Modifier.padding(MyTheme.dimensions.contentPadding)) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(MyTheme.colors.primary),
                    contentAlignment = Alignment.Center
                ) {
                    MyText(
                        text = "mpe",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            lineHeight = 14.sp,
                        ),
                        color = MyTheme.colors.textInverse
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                MyText(
                    text = "Multiplatform Example", style = MyTheme.typography.subTitle
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
                        text = "Primary button",
                    ) {
                    }
                    MyButton(
                        text = "Secondary button",
                        icon = TablerIcons.ArrowUpRight,
                        style = MyButtonStyle.Secondary
                    ) {
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            MyBanner(
                modifier = Modifier.fillMaxWidth(),
                title = "Banner",
                description = "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod tempor incididunt.",
            ) {

            }
        }
    }
}