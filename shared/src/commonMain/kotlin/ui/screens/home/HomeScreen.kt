package ui.screens.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import co.touchlab.kermit.Logger
import com.moriatsushi.insetsx.statusBars
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowRight
import compose.icons.tablericons.ArrowUpRight
import compose.icons.tablericons.Refresh
import data.api.state.NetworkDataState
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import ui.library.banner.MyBanner
import ui.library.buttons.MyButton
import ui.library.buttons.MyButtonStyle
import ui.library.error.MyErrorStateComponent
import ui.library.loading.MyLoadingIndicator
import ui.library.text.MyText
import ui.theme.MyTheme

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel<HomeScreenModel>()
        val scrollState = rememberScrollState()

        LaunchedEffect(screenModel) {
            screenModel.init()
        }

        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
                .windowInsetsPadding(WindowInsets.statusBars),
        ) {
            Column(modifier = Modifier.padding(MyTheme.dimensions.contentPadding)) {
                Box(
                    modifier = Modifier.size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MyTheme.colors.primary),
                    contentAlignment = Alignment.Center
                ) {
                    MyText(
                        text = "mpe",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            lineHeight = 14.sp,
                        ),
                        color = MyTheme.colors.textInverse
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                MyText(
                    text = "Multiplatform Example",
                    style = MyTheme.typography.title
                )
                Spacer(modifier = Modifier.height(4.dp))
                MyText(
                    text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    MyButton(
                        text = "Primary button",
                        icon = TablerIcons.ArrowRight,
                    ) {}
                    MyButton(
                        text = "Secondary button",
                        icon = TablerIcons.ArrowUpRight,
                        style = MyButtonStyle.Secondary
                    ) {}
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            AnimatedContent(
                targetState = screenModel.fact,
            ) { state ->
                when (state) {
                    is NetworkDataState.Error -> MyErrorStateComponent(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = MyTheme.dimensions.contentPadding),
                    )

                    is NetworkDataState.Success -> MyBanner(
                        modifier = Modifier.fillMaxWidth(),
                        actionIcon = TablerIcons.Refresh,
                        description = state.data.facts.firstOrNull().orEmpty(),
                    ) {
                        screenModel.request()
                    }

                    else -> MyLoadingIndicator(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = MyTheme.dimensions.contentPadding)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth().height(156.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = MyTheme.dimensions.contentPadding)
            ) {
                items(screenModel.dogImages, key = { it }) { url ->
                    KamelImage(
                        modifier = Modifier.fillMaxHeight()
                            .clip(RoundedCornerShape(8.dp))
                            .background(MyTheme.colors.surface)
                            .aspectRatio(1F),
                        resource = asyncPainterResource(data = url),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        animationSpec = tween(),
                    )
                }
            }
            Column(modifier = Modifier.padding(MyTheme.dimensions.contentPadding)) {
                MyText(
                    text = "More information",
                    style = MyTheme.typography.subTitle
                )
                Spacer(modifier = Modifier.height(4.dp))
                MyText(
                    text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
                )
                Spacer(modifier = Modifier.height(12.dp))
                MyText(
                    text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
                )
            }
        }
    }
}