package ui.library.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowRight
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun MyBanner(
    modifier: Modifier = Modifier,
    actionIcon: ImageVector = TablerIcons.ArrowRight,
    description: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = MyTheme.colors.primary)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = MyTheme.colors.textInverse
                ),
                onClick = onClick
            )
    ) {
        MyText(
            modifier = Modifier.fillMaxWidth().padding(16.dp).padding(end = 24.dp),
            text = description, style = MyTheme.typography.body,
            color = MyTheme.colors.textInverse
        )
        Icon(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(MyTheme.colors.surface)
                .size(24.dp)
                .padding(4.dp),
            imageVector = actionIcon,
            tint = MyTheme.colors.text,
            contentDescription = null,
        )
    }
}