package ui.library.loading

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.theme.MyTheme

@Composable
fun MyLoadingIndicator(
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        modifier = modifier,
        color = MyTheme.colors.primary,
        trackColor = MyTheme.colors.surface
    )
}