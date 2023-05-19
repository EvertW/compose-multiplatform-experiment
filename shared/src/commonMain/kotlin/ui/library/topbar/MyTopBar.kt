package ui.library.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowLeft
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
                modifier = Modifier.size(56.dp).padding(16.dp).clickable(onClick = onBack),
                imageVector = FeatherIcons.ArrowLeft,
                contentDescription = "Go back",
                tint = MyTheme.colors.text
            )
        }
        content?.invoke(this)
    }
}