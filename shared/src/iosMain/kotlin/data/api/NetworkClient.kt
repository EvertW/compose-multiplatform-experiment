package data.api

import io.ktor.client.engine.darwin.Darwin

actual fun provideEngine() = Darwin.create {
    configureRequest {
        setAllowsCellularAccess(true)
    }
}