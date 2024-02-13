package di

import di.modules.NetworkModule
import di.modules.RepositoryModule
import di.modules.ScreenModelModule
import di.modules.StorageModule
import org.kodein.di.DI

fun createDependencyInjector() = DI.lazy {
    import(StorageModule)
    import(NetworkModule)
    import(RepositoryModule)
    import(ScreenModelModule)
}