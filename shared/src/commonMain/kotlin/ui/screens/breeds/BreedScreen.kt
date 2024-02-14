package ui.screens.breeds

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberNavigatorScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.evertwoud.multiplatform.example.MR
import com.moriatsushi.insetsx.statusBars
import data.network.state.NetworkDataState
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.desc.desc
import ui.library.error.MyErrorStateComponent
import ui.library.loading.MyLoadingIndicator
import ui.library.text.MyText
import ui.screens.breeds.component.BreedRow
import ui.theme.MyTheme

object BreedScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = navigator.rememberNavigatorScreenModel<BreedScreenModel>()

        LaunchedEffect(screenModel) {
            screenModel.init()
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.statusBars),
            contentPadding = PaddingValues(vertical = MyTheme.dimensions.contentPadding)
        ) {
            item("header") {
                MyText(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = MyTheme.dimensions.contentPadding),
                    text = MR.strings.breeds_title.desc().localized(),
                    style = MyTheme.typography.title
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            when (val state = screenModel.breeds) {
                is NetworkDataState.Error -> item("error") {
                    MyErrorStateComponent(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = MyTheme.dimensions.contentPadding),
                    )
                }

                is NetworkDataState.Success -> items(
                    items = state.data,
                    key = { it.id }
                ) { breed ->
                    BreedRow(breed = breed)
                }

                else -> item("loader") {
                    MyLoadingIndicator(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = MyTheme.dimensions.contentPadding)
                    )
                }
            }

            item("bottom-spacer") { Spacer(modifier = Modifier.height(MyTheme.dimensions.contentPadding)) }
        }
    }
}