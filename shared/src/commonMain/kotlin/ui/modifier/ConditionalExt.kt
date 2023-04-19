package ui.modifier

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Modifier.conditional(condition: Boolean, producer: @Composable Modifier.() -> Modifier) =
    if (condition) this.then(producer.invoke(this)) else this