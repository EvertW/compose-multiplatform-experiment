package ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.library.buttons.MyButton
import ui.library.buttons.MyButtonStyle
import ui.library.text.MyText
import ui.theme.MyTheme

class DetailScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(scrollState)
                .padding(MyTheme.dimensions.contentPadding),
        ) {
            MyText(
                text = "Detail page",
                style = MyTheme.typography.title
            )
            Spacer(modifier = Modifier.height(8.dp))
            MyText(
                text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
            )
            Spacer(modifier = Modifier.height(12.dp))
            MyButton(
                text = "Go back", style = MyButtonStyle.Secondary
            ) {
                navigator.pop()
            }
        }
    }
}