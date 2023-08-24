package ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import data.api.NetworkClient
import data.api.state.networkDataStateOf
import data.models.ExampleResponse
import kotlinx.coroutines.launch

class HomeScreenModel(
    private val api: NetworkClient,
) : ScreenModel {

    var fact by networkDataStateOf<ExampleResponse>()

    fun init() {
        request()
    }

    fun request() {
        coroutineScope.launch {
            api.getExampleResponse().collect {
                fact = it
            }
        }
    }
}