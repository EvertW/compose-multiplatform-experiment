package ui.screens.trips

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import data.api.NetworkClient
import data.api.state.NetworkDataState
import data.api.state.networkDataStateOf
import data.models.Trip
import kotlinx.coroutines.launch

class TripScreenModel(
    private val api: NetworkClient
) : ScreenModel {

    var state by networkDataStateOf<List<Trip>>()
        private set

    fun init() {
        coroutineScope.launch {
            state = NetworkDataState.Success(
                listOf(
                    Trip(
                        id = 1,
                        destination = "Tokyo",
                        country = "Japan",
                        startDate = 1687793606L,
                        endDate = 1687793606L,
                    ),
                    Trip(
                        id = 2,
                        destination = "Sydney",
                        country = "Australia",
                        startDate = 1687793606L,
                        endDate = 1687793606L,
                    ),
                    Trip(
                        id = 3,
                        destination = "Amsterdam",
                        country = "Netherlands",
                        startDate = 1687793606L,
                        endDate = 1687793606L,
                    )
                )
            )
        }
    }
}