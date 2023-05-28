package ui.screens.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import ui.library.text.MyText
import ui.screens.calendar.components.CalendarEventItem
import ui.theme.MyTheme

object CalendarScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { CalendarScreenModel() }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(MyTheme.dimensions.contentPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(key = "tile") {
                MyText(
                    text = "Upcoming events", style = MyTheme.typography.title
                )
            }
            items(screenModel.talks, key = { it.id }) {
                CalendarEventItem(
                    event = it,
                )
            }
        }
    }
}