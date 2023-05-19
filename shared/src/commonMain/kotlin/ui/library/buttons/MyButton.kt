package ui.library.buttons

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ui.library.text.MyText
import ui.modifier.conditional
import ui.theme.MyTheme

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    text: String,
    style: MyButtonStyle = MyButtonStyle.Primary,
    onClick: () -> Unit
) {
    val shape = remember { CircleShape }
    val interactionSource = remember { MutableInteractionSource() }
    MyText(
        modifier = modifier
            .animateContentSize()
            .clip(shape)
            .background(
                when (style) {
                    MyButtonStyle.Primary -> MyTheme.colors.primary
                    MyButtonStyle.Secondary -> MyTheme.colors.background
                }
            )
            .conditional(condition = style == MyButtonStyle.Secondary) {
                border(
                    width = 2.dp,
                    color = MyTheme.colors.text,
                    shape = shape
                )
            }
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(
                    color = when (style) {
                        MyButtonStyle.Primary -> MyTheme.colors.textInverse
                        MyButtonStyle.Secondary -> MyTheme.colors.text
                    },
                )
            ) {
                onClick.invoke()
            }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        text = text,
        color = when (style) {
            MyButtonStyle.Primary -> MyTheme.colors.textInverse
            MyButtonStyle.Secondary -> MyTheme.colors.text
        },
        style = MyTheme.typography.button
    )
}

sealed class MyButtonStyle {
    object Primary : MyButtonStyle()
    object Secondary : MyButtonStyle()
}