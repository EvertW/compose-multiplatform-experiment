package ui.screens.breeds.component.dialog

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import data.models.api.BreedResponse
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun BreedDetailDialog(
    breed: BreedResponse,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)).background(MyTheme.colors.surface)
                .fillMaxWidth().padding(MyTheme.dimensions.contentPadding)
        ) {
            KamelImage(
                modifier = Modifier.aspectRatio(4F / 3F).fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)).background(MyTheme.colors.surface),
                resource = asyncPainterResource(
                    key = breed.reference_image_id,
                    data = "https://cdn2.thedogapi.com/images/${breed.reference_image_id}.jpg"
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                animationSpec = tween(),
            )
            Spacer(modifier = Modifier.height(12.dp))
            MyText(
                modifier = Modifier.fillMaxWidth(),
                style = MyTheme.typography.subTitle,
                text = breed.name,
            )
            DetailRow(
                label = "Origin",
                value = breed.origin
            )
            DetailRow(
                label = "Life span",
                value = breed.life_span
            )
            DetailRow(
                label = "Temperament",
                value = breed.temperament
            )
            DetailRow(
                label = "Bred for",
                value = breed.bred_for
            )
        }
    }
}

@Composable
private fun DetailRow(
    label: String,
    value: String?
) {
    value?.takeIf { it.isNotBlank() }?.let {
        Spacer(modifier = Modifier.height(12.dp))
        MyText(
            modifier = Modifier.fillMaxWidth(),
            style = MyTheme.typography.label,
            text = label,
        )
        Spacer(modifier = Modifier.height(2.dp))
        MyText(
            modifier = Modifier.fillMaxWidth(),
            style = MyTheme.typography.body,
            text = value,
        )
    }
}