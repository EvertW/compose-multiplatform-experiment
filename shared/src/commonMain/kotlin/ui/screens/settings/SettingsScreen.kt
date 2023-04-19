package ui.screens.settings

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
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.fillMaxSize().verticalScroll(scrollState)
            .padding(MyTheme.dimensions.contentPadding),
    ) {
        MyText(
            text = "Settings", style = MyTheme.typography.title
        )
        Spacer(modifier = Modifier.height(4.dp))
        MyText(
            text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
        )
    }
}