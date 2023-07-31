package ui.screens.trips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.moriatsushi.insetsx.statusBars
import data.api.NetworkClient
import data.api.state.NetworkDataState
import ui.screens.trips.components.TripRow
import ui.library.loading.MyLoadingIndicator
import ui.library.text.MyText
import ui.theme.MyTheme

object TripScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { TripScreenModel(NetworkClient()) }

        LaunchedEffect(screenModel) {
            screenModel.init()
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.statusBars),
            contentPadding = PaddingValues(MyTheme.dimensions.contentPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(key = "tile") {
                MyText(
                    text = "Exchange rates",
                    style = MyTheme.typography.title
                )
            }
            when (val state = screenModel.state) {
                is NetworkDataState.Success -> items(state.data, key = { it.id }) {
                    TripRow(
                        modifier = Modifier.fillMaxWidth(),
                        trip = it
                    ) {

                    }
                }

                is NetworkDataState.Error -> item {
                    MyText(
                        text = "The data could not be fetched at the moment.",
                    )
                }

                else -> item {
                    MyLoadingIndicator(
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}