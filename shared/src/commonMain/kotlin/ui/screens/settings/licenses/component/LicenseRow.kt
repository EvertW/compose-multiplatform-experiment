package ui.screens.settings.licenses.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikepenz.aboutlibraries.entity.Library
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun LicenseRow(
    modifier: Modifier,
    library: Library,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable(onClick = onClick).padding(MyTheme.dimensions.contentPadding)
    ) {
        MyText(
            modifier = Modifier.fillMaxWidth(),
            text = library.organization?.name ?: library.developers.joinToString(", ") {
                it.name.orEmpty()
            },
            style = MyTheme.typography.label
        )
        Spacer(modifier = Modifier.height(2.dp))
        MyText(
            modifier = Modifier.fillMaxWidth(),
            text = library.name,
            style = MyTheme.typography.listItem
        )
        Spacer(modifier = Modifier.height(4.dp))
        MyText(
            modifier = Modifier.background(MyTheme.colors.primary).padding(4.dp),
            text = library.licenses.joinToString(", ") { it.name },
            color = MyTheme.colors.textInverse,
            style = MyTheme.typography.label
        )
    }
}