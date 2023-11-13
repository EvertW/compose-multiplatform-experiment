package data.api.requests

import data.api.NetworkClient
import data.api.state.NetworkDataState
import data.models.api.BreedResponse
import data.models.api.FactsResponse
import kotlinx.coroutines.flow.Flow

class NetworkRequests(
    private val client: NetworkClient
) {

    suspend fun getFacts(): Flow<NetworkDataState<FactsResponse>> = client.networkRequest(
        url = "https://dog-api.kinduff.com/api/facts"
    )

    suspend fun getBreeds(): Flow<NetworkDataState<List<BreedResponse>>> = client.networkRequest(
        url = "https://api.thedogapi.com/v1/breeds",
    )
}