package data.api.state

import androidx.compose.runtime.mutableStateOf

fun <T> networkDataStateOf(
    default: NetworkDataState<T>? = NetworkDataState.Loading
) = mutableStateOf(default)

suspend fun <T, R> NetworkDataState<T>.transform(transformer: suspend (T) -> R): NetworkDataState<R> {
    return when (this) {
        is NetworkDataState.Success -> NetworkDataState.Success(transformer(data))
        is NetworkDataState.Loading -> NetworkDataState.Loading
        is NetworkDataState.Error -> NetworkDataState.Error(error)
    }
}

suspend fun <T> NetworkDataState<T>.process(
    onLoading: suspend () -> Unit = {},
    onError: suspend (data: Throwable?) -> Unit = {},
    onSuccess: suspend (data: T) -> Unit = {},
) {
    when (this) {
        is NetworkDataState.Success -> onSuccess(data)
        is NetworkDataState.Loading -> onLoading()
        is NetworkDataState.Error -> onError(error)
    }
}

fun <T> NetworkDataState<T?>.requireNotNull(): NetworkDataState<T> {
    return when (this) {
        is NetworkDataState.Success -> when (data != null) {
            true -> NetworkDataState.Success(data)
            false -> NetworkDataState.Error()
        }

        is NetworkDataState.Loading -> NetworkDataState.Loading
        is NetworkDataState.Error -> NetworkDataState.Error(error)
    }
}

fun <T> NetworkDataState<T>.success(): NetworkDataState.Success<T>? {
    return this as? NetworkDataState.Success
}

fun <T> NetworkDataState<T>.loading(): NetworkDataState.Loading? {
    return this as? NetworkDataState.Loading
}

fun <T> NetworkDataState<T>.error(): NetworkDataState.Error<T>? {
    return this as? NetworkDataState.Error
}

fun <A, B> zip(
    first: NetworkDataState<A>,
    second: NetworkDataState<B>,
): NetworkDataState<Pair<A, B>> {
    val states = listOf(first, second)
    return when {
        states.all { it is NetworkDataState.Success } -> {
            NetworkDataState.Success(
                data = Pair(
                    first = first.success()!!.data,
                    second = second.success()!!.data,
                ),
            )
        }

        states.any { it is NetworkDataState.Error } -> {
            NetworkDataState.Error(
                error = states.firstNotNullOfOrNull { it.error()?.error },
            )
        }

        else -> NetworkDataState.Loading
    }
}

fun <A, B, C> zip(
    first: NetworkDataState<A>,
    second: NetworkDataState<B>,
    third: NetworkDataState<C>,
): NetworkDataState<Triple<A, B, C>> {
    val states = listOf(first, second, third)
    return when {
        states.all { it is NetworkDataState.Success } -> {
            NetworkDataState.Success(
                data = Triple(
                    first = first.success()!!.data,
                    second = second.success()!!.data,
                    third = third.success()!!.data,
                ),
            )
        }

        states.any { it is NetworkDataState.Error } -> {
            NetworkDataState.Error(
                error = states.firstNotNullOfOrNull { it.error()?.error },
            )
        }

        else -> NetworkDataState.Loading
    }
}