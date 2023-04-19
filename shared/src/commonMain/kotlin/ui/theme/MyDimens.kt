package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class MyDimens(
    val contentPadding: Dp,
    val cardRadius: Dp,
)

fun MyDimens() = MyDimens(
    contentPadding = 16.dp,
    cardRadius = 12.dp
)
