package di.modules

import data.storage.PreferenceStorage
import org.kodein.di.DI
import org.kodein.di.bindSingleton

expect fun providePreferenceStorage(): PreferenceStorage

val StorageModule = DI.Module(name = "StorageModule") {
    bindSingleton { providePreferenceStorage() }
}