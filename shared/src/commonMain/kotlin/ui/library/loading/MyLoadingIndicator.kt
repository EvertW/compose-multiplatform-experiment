package ui.library.loading

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import ui.theme.MyTheme

@Composable
fun MyLoadingIndicator(
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        modifier = modifier.clip(CircleShape),
        color = MyTheme.colors.primary,
        backgroundColor = MyTheme.colors.surface,
    )
}