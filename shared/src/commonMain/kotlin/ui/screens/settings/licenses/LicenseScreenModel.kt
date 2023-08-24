import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.entity.Library


class LicenseScreenModel : ScreenModel {
    var libs by mutableStateOf<Libs?>(null)
    var selection by mutableStateOf<Library?>(null)

    fun load(licenceJson: String) {
        libs = Libs.Builder()
            .withJson(licenceJson) // provide the metaData (alternative APIs available)
            .build()
    }
}