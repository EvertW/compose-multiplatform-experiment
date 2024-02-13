package di.modules

import data.storage.PreferenceStorage
import org.kodein.di.DI
import org.kodein.di.bindSingleton

expect fun providePreferenceStorage() : PreferenceStorage

val StorageModule = DI.Module(name = "StorageModule") {
    bindSingleton { providePreferenceStorage() }
}


// IOS:

/*
PreferenceDataStoreFactory.createWithPath(
    corruptionHandler = null,
    migrations = emptyList(),
    produceFile = { path("$fileName.preferences_pb").toPath() },
)
*/


// Android:

/*
path = { fileName -> context.filesDir.resolve(fileName).absolutePath }
* */
