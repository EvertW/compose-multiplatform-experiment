package di

import data.storage.PreferenceStorage
import di.modules.NetworkModule
import di.modules.ScreenModelModule
import di.modules.createStorageModule
import org.kodein.di.DI

fun createDependencyInjector(
    preferences: PreferenceStorage
) = DI.lazy {
    import(createStorageModule(preferences))
    import(NetworkModule)
    import(ScreenModelModule)
}