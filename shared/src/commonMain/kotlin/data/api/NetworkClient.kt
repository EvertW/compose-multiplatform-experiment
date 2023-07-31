package data.api

import data.api.state.NetworkDataState
import data.models.Trip
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class NetworkClient {
    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                explicitNulls = false
                ignoreUnknownKeys = true
                coerceInputValues = true
                useArrayPolymorphism = true
                allowSpecialFloatingPointValues = true
            })

        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    private suspend inline fun <reified T> networkRequest(
        url: String,
        crossinline builder: (HttpRequestBuilder.() -> Unit) = ({}),
    ): Flow<NetworkDataState<T>> = flow {
        emit(NetworkDataState.Loading)
        try {
            val result = client.get(url, block = builder).body<T>()
            emit(NetworkDataState.Success(result))
        } catch (e: Exception) {
            emit(NetworkDataState.Error(e))
        }
    }

    suspend fun getJokes(): Flow<NetworkDataState<Trip>> {
        return networkRequest(
            url = "https://v2.jokeapi.dev/joke/Any?type=twopart&amount=10",
        )
    }
}