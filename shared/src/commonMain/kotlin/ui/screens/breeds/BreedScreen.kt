package ui.screens.breeds

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberNavigatorScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.evertwoud.multiplatform.resources.Res
import com.evertwoud.multiplatform.resources.breeds_title
import com.moriatsushi.insetsx.statusBars
import data.models.api.BreedResponse
import data.network.state.NetworkDataState
import org.jetbrains.compose.resources.stringResource
import ui.library.error.MyErrorStateComponent
import ui.library.loading.MyLoadingIndicator
import ui.library.text.MyText
import ui.screens.breeds.component.BreedRow
import ui.screens.breeds.component.dialog.BreedDetailDialog
import ui.theme.MyTheme

object BreedScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = navigator.rememberNavigatorScreenModel<BreedScreenModel>()
        var detail by remember { mutableStateOf<BreedResponse?>(null) }

        LaunchedEffect(screenModel) {
            screenModel.init()
        }

        detail?.let { breed ->
            BreedDetailDialog(breed = breed) {
                detail = null
            }
        }

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.statusBars),
            contentPadding = PaddingValues(MyTheme.dimensions.contentPadding),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            columns = GridCells.Fixed(2)
        ) {
            item("header", span = { GridItemSpan(2) }) {
                MyText(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.breeds_title),
                    style = MyTheme.typography.title
                )
                Spacer(modifier = Modifier.height(MyTheme.dimensions.contentPadding))
            }
            when (val state = screenModel.breeds) {
                is NetworkDataState.Error -> item("error", span = { GridItemSpan(2) }) {
                    MyErrorStateComponent(modifier = Modifier.fillMaxWidth())
                }

                is NetworkDataState.Success -> items(items = state.data, key = { it.id }) { breed ->
                    BreedRow(breed = breed) {
                        detail = breed
                    }
                }

                else -> item("loader", span = { GridItemSpan(2) }) {
                    MyLoadingIndicator(modifier = Modifier.fillMaxWidth())
                }
            }

            item("bottom-spacer") { Spacer(modifier = Modifier.height(MyTheme.dimensions.contentPadding)) }
        }
    }
}