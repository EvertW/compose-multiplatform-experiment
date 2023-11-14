package ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class MyDimens(
    val contentPadding: Dp,
    val navigationBarHeight: Dp,
)

fun MyDimens() = MyDimens(
    contentPadding = 16.dp,
    navigationBarHeight = 64.dp,
)
