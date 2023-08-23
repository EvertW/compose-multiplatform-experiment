package di

import di.modules.NetworkModule
import di.modules.ScreenModelModule
import org.kodein.di.DI

val DependencyInjector = DI.lazy {
    import(NetworkModule)
    import(ScreenModelModule)
}