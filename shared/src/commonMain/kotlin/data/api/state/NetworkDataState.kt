package data.api.state

import androidx.compose.runtime.Immutable

@Immutable
sealed class NetworkDataState<out T> {
    object Loading : NetworkDataState<Nothing>()
    data class Success<T>(val data: T) : NetworkDataState<T>()
    data class Error<T>(val error: Throwable? = null) : NetworkDataState<T>()
}
