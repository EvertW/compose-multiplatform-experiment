package ui.library.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ui.theme.MyTheme

@Composable
fun MyBottomMenu(
    modifier: Modifier = Modifier,
    items: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier.background(color = MyTheme.colors.background).height(56.dp),
        content = items
    )
}

@Composable
fun RowScope.MyBottomMenuItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier.weight(1F).clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = modifier.fillMaxHeight().height(24.dp),
            imageVector = icon,
            tint = MyTheme.colors.text,
            contentDescription = contentDescription,
        )
    }
}