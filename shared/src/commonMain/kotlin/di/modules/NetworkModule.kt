package di.modules

import data.network.NetworkClient
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val NetworkModule = DI.Module(name = "NetworkModule") {
    bindSingleton { NetworkClient() }
}