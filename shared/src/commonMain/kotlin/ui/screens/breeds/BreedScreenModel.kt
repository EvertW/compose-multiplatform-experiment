package ui.screens.breeds

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import data.api.NetworkClient
import data.api.state.networkDataStateOf
import data.models.api.BreedResponse
import data.models.api.FactsResponse
import kotlinx.coroutines.launch

class BreedScreenModel(
    private val api: NetworkClient,
) : ScreenModel {


    var breeds by networkDataStateOf<List<BreedResponse>>()

    fun init() {
        request()
    }

    private fun request() {
        screenModelScope.launch {
            api.requests.getBreeds().collect {
                breeds = it
            }
        }
    }
}