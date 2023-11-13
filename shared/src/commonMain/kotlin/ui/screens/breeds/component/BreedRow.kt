package ui.screens.breeds.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.models.api.BreedResponse
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun BreedRow(
    modifier: Modifier = Modifier,
    breed: BreedResponse,
) {
    MyText(
        modifier = modifier.fillMaxWidth().padding(MyTheme.dimensions.contentPadding),
        style = MyTheme.typography.listItem,
        text = breed.name,
    )
}