package data.storage

import android.content.Context

fun dataStore(context: Context) = PreferenceStorage.create(
    path = { fileName -> context.filesDir.resolve(fileName).absolutePath }
)