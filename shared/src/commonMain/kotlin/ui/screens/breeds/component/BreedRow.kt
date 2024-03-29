package ui.screens.breeds.component

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import data.models.api.BreedResponse
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun BreedRow(
    modifier: Modifier = Modifier,
    breed: BreedResponse,
    onClick: () -> Unit
) {
    Column(modifier.fillMaxSize()) {
        KamelImage(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1F)
                .clip(RoundedCornerShape(12.dp))
                .background(MyTheme.colors.surface)
                .clickable(onClick = onClick),
            resource = asyncPainterResource(
                key = breed.reference_image_id,
                data = breed.image
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            animationSpec = tween(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        MyText(
            modifier = Modifier.fillMaxWidth(),
            style = MyTheme.typography.listItem,
            text = breed.name,
            maxLines = 1
        )
    }
}