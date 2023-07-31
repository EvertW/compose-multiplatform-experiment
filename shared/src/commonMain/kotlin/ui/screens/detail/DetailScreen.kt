package ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.moriatsushi.insetsx.navigationBars
import com.moriatsushi.insetsx.statusBars
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowRight
import ui.library.text.MyText
import ui.library.topbar.MyTopBar
import ui.theme.MyTheme

class DetailScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.statusBars),
        ) {
            MyTopBar(
                content = {
                    MyText(
                        text = "Detail page",
                        style = MyTheme.typography.title
                    )
                },
                onBack = {
                    navigator.pop()
                }
            )
            Column(
                modifier = Modifier.weight(1F)
                    .verticalScroll(scrollState)
                    .padding(MyTheme.dimensions.contentPadding)
                    .windowInsetsPadding(WindowInsets.navigationBars),
            ) {
                MyText(
                    text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
                )
                Spacer(modifier = Modifier.height(12.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(5) {
                        Row(
                            modifier = Modifier
                                .background(color = MyTheme.colors.surface)
                                .clickable {}
                                .padding(24.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            MyText(
                                text = "Detail tile"
                            )
                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = TablerIcons.ArrowRight,
                                contentDescription = null,
                            )
                        }
                    }
                }
            }
        }
    }
}