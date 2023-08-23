package ui.resources

import androidx.compose.runtime.Composable
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun loadLicences(): String {
    val byteArray = runBlocking {
        resource("raw/aboutlibraries.json").readBytes()
    }
    return byteArray.decodeToString()
}