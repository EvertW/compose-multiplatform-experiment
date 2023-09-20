import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.entity.Library
import data.api.state.NetworkDataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch


class LicenseScreenModel : ScreenModel {
    var libs by mutableStateOf<NetworkDataState<Libs>>(NetworkDataState.Loading)
    var selection by mutableStateOf<Library?>(null)

    fun load(licenceJson: String) {
        coroutineScope.launch(Dispatchers.IO) {
            libs = NetworkDataState.Success(
                Libs.Builder()
                    .withJson(licenceJson) // provide the metaData (alternative APIs available)
                    .build()
            )
        }
    }
}