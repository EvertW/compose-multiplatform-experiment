package ui.library.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowRight
import compose.icons.tablericons.InfoCircle
import compose.icons.tablericons.InfoSquare
import compose.icons.tablericons.QuestionMark
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun MyBanner(
    modifier: Modifier = Modifier,
    icon: ImageVector = TablerIcons.InfoCircle,
    actionIcon: ImageVector = TablerIcons.ArrowRight,
    description: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(color = MyTheme.colors.primary)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = MyTheme.colors.textInverse
                ),
                onClick = onClick
            )
    ) {
        Column(Modifier.fillMaxWidth().padding(16.dp).padding(end = 24.dp)) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = icon,
                tint = MyTheme.colors.textInverse,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(4.dp))
            MyText(
                text = description, style = MyTheme.typography.body,
                color = MyTheme.colors.textInverse
            )
        }
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