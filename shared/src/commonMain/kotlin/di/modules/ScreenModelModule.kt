package di.modules

import LicenseScreenModel
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance
import ui.screens.home.HomeScreenModel
import ui.screens.settings.SettingsScreenModel
import ui.screens.settings.issue.ReportIssueScreenModel

val ScreenModelModule = DI.Module(name = "ScreenModelModule") {
    bindProvider { HomeScreenModel(api = instance()) }
    bindProvider { SettingsScreenModel(preferences = instance()) }
    bindProvider { ReportIssueScreenModel() }
    bindProvider { LicenseScreenModel() }
}