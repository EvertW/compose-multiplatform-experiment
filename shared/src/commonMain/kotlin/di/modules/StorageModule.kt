package di.modules

import data.storage.PreferenceStorage
import org.kodein.di.DI
import org.kodein.di.bindSingleton

fun createStorageModule(
    preferences: PreferenceStorage
) = DI.Module(name = "StorageModule") {
    bindSingleton { preferences }
}