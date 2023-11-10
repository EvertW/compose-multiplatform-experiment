import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.model.screenModelScope
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.entity.Library
import data.api.state.NetworkDataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch


class LicenseScreenModel : ScreenModel {
    var libs by mutableStateOf<NetworkDataState<Libs>>(NetworkDataState.Loading)

    fun load(licenceJson: String) {
        screenModelScope.launch(Dispatchers.IO) {
            libs = NetworkDataState.Success(
                Libs.Builder()
                    .withJson(licenceJson) // provide the metaData (alternative APIs available)
                    .build()
            )
        }
    }
}