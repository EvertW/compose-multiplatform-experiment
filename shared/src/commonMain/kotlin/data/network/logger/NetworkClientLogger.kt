package data.network.logger

import io.ktor.client.plugins.logging.Logger
import  co.touchlab.kermit.Logger as Log

private const val LOG_TAG = "NetworkClient"

val NetworkClientLogger = object : Logger {
    override fun log(message: String) = Log.d(
        messageString = message,
        tag = LOG_TAG
    )
}