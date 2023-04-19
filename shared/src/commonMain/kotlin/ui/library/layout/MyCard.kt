package ui.library.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.MyTheme

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val shape = RoundedCornerShape(MyTheme.dimensions.cardRadius)
    Column(
        modifier = modifier
            .background(color = MyTheme.colors.surface, shape = shape)
            .border(1.dp, MyTheme.colors.divider, shape)
            .padding(MyTheme.dimensions.contentPadding),
        content = content
    )
}