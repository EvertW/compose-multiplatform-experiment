package di

import di.modules.NetworkModule
import di.modules.ScreenModelModule
import di.modules.SettingsModule
import org.kodein.di.DI

val DependencyInjector = DI.lazy {
    import(NetworkModule)
    import(ScreenModelModule)
    import(SettingsModule)
}