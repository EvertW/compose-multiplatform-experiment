package di.modules

import data.settings.SettingsManager
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val SettingsModule = DI.Module(name = "SettingsModule") {
    bindSingleton { SettingsManager() }
}