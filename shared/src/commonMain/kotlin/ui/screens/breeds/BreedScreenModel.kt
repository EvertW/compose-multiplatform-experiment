package ui.screens.breeds

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import data.models.api.BreedResponse
import data.network.state.NetworkDataState
import data.network.state.networkDataStateOf
import data.repository.DogRepository
import kotlinx.coroutines.launch

class BreedScreenModel(
    private val dogRepository: DogRepository
) : ScreenModel {


    var breeds by networkDataStateOf<List<BreedResponse>>()

    fun init() {
        if (breeds !is NetworkDataState.Success) request()
    }

    private fun request() {
        screenModelScope.launch {
            dogRepository.getBreeds().collect {
                breeds = it
            }
        }
    }
}