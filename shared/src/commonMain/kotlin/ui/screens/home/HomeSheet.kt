package ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ui.library.text.MyText
import ui.theme.MyTheme

class HomeSheet : Screen {
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.wrapContentHeight().padding(MyTheme.dimensions.contentPadding),
        ) {
            MyText(
                text = "Title", style = MyTheme.typography.title
            )
            Spacer(modifier = Modifier.height(4.dp))
            MyText(
                text = "Subtitle", style = MyTheme.typography.subTitle
            )
        }
    }
}