package ui.screens.breeds

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import data.api.state.NetworkDataState
import data.api.state.networkDataStateOf
import data.models.api.BreedResponse
import data.repository.DogRepository
import kotlinx.coroutines.launch
import org.kodein.di.DIAware

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