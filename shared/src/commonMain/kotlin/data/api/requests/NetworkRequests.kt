package data.api.requests

import data.api.NetworkClient
import data.api.state.NetworkDataState
import data.models.FactsResponse
import kotlinx.coroutines.flow.Flow

class NetworkRequests(
    private val client: NetworkClient
) {

    suspend fun getFacts(): Flow<NetworkDataState<FactsResponse>> {
        return client.networkRequest(
            url = "https://dog-api.kinduff.com/api/facts",
        )
    }
}