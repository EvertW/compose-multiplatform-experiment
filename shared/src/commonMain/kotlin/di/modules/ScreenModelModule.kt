package di.modules

import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance
import ui.screens.settings.SettingsScreenModel

val ScreenModelModule = DI.Module(name = "ScreenModelModule") {
    bindProvider {
        SettingsScreenModel(
            api = instance(),
        )
    }
}