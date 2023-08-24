package data.api

import io.ktor.client.engine.cio.CIO

actual fun provideEngine() = CIO.create()