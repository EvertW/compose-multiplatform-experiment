package ui.library.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import ui.theme.MyTheme

@Composable
fun MyTopBar(
    modifier: Modifier = Modifier,
    content: @Composable (RowScope.() -> Unit)? = null,
    onBack: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .background(color = MyTheme.colors.background)
            .heightIn(min = 56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        onBack?.let {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(56.dp)
                    .padding(8.dp)
                    .clickable(onClick = onBack)
                    .padding(8.dp),
                imageVector = TablerIcons.ArrowLeft,
                contentDescription = "Go back",
                tint = MyTheme.colors.text
            )
        }
        content?.invoke(this)
    }
}