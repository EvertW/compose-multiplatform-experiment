package di.modules

import data.storage.PreferenceStorage
import util.ApplicationContextProvider

actual fun providePreferenceStorage() = PreferenceStorage.create(
    path = { fileName -> ApplicationContextProvider.applicationContext.filesDir.resolve(fileName).absolutePath }
)
