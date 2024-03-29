package data.network

import data.network.logger.NetworkClientLogger
import data.network.state.NetworkDataState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class NetworkClient {
    companion object {
        private const val LOG_TAG = "NetworkClient"
    }

    @OptIn(ExperimentalSerializationApi::class)
    val client = HttpClient(provideEngine()) {
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
            logger = NetworkClientLogger
            level = LogLevel.ALL
        }
    }

    suspend inline fun <reified T> networkRequest(
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
}

expect fun provideEngine(): HttpClientEngine