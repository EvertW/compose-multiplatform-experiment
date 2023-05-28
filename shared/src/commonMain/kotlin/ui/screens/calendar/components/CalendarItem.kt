package ui.screens.calendar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowRight
import data.models.CalendarEvent
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun CalendarEventItem(
    event: CalendarEvent,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MyTheme.colors.surface)
            .clickable {}
            .padding(24.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MyText(
                modifier = Modifier.weight(1F, false),
                text = event.title,
                maxLines = 1,
                style = MyTheme.typography.subTitle
            )
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = FeatherIcons.ArrowRight,
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        MyText(
            text = event.description,
            style = MyTheme.typography.body,
        )
        Spacer(modifier = Modifier.height(8.dp))
        MyText(
            text = event.speaker,
            style = MyTheme.typography.label,
        )
    }
}