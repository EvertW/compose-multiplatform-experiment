package ui.resources

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@SuppressLint("DiscouragedApi")
@Composable
actual fun loadLicences(): String {
    val context = LocalContext.current
    val id = context.resources.getIdentifier("aboutlibraries", "raw", context.packageName)
    context.resources.openRawResource(id).use {
        return it.bufferedReader().readText()
    }
}