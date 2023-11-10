package ui.screens.settings.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowRight
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun SettingsRow(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(MyTheme.dimensions.contentPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MyText(
            modifier = Modifier.weight(1F),
            style = MyTheme.typography.listItem,
            text = label,
        )
        Icon(
            modifier = Modifier
                .background(MyTheme.colors.primary)
                .size(24.dp)
                .padding(4.dp),
            imageVector = TablerIcons.ArrowRight,
            tint = MyTheme.colors.textInverse,
            contentDescription = null,
        )
    }
}