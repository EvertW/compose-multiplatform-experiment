package ui.library.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.evertwoud.multiplatform.example.MR
import compose.icons.TablerIcons
import compose.icons.tablericons.AlertTriangle
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.desc.desc
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun MyErrorStateComponent(
    modifier: Modifier = Modifier,
    error: String? = null
) {
    Row(
        modifier = modifier
            .background(MyTheme.colors.surface)
            .padding(MyTheme.dimensions.contentPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = TablerIcons.AlertTriangle,
            tint = MyTheme.colors.text,
            contentDescription = error,
        )
        MyText(
            modifier = Modifier.weight(1F),
            text = error ?: MR.strings.error_generic.desc().localized(),
            style = MyTheme.typography.button,
            color = MyTheme.colors.text,
        )
    }
}