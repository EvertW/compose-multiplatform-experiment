package ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import data.api.NetworkClient
import data.api.state.NetworkDataState
import data.api.state.networkDataStateOf
import data.models.api.FactsResponse
import kotlinx.coroutines.launch

class HomeScreenModel(
    private val api: NetworkClient,
) : ScreenModel {

    val dogImages = listOf(
        "https://www.princeton.edu/sites/default/files/styles/1x_full_2x_half_crop/public/images/2022/02/KOA_Nassau_2697x1517.jpg?itok=Bg2K7j7J",
        "https://www.daysoftheyear.com/cdn-cgi/image/dpr=1%2Cf=auto%2Cfit=cover%2Cheight=650%2Cq=40%2Csharpen=1%2Cwidth=956/wp-content/uploads/puppy-day-e1574071869348.jpg",
        "https://hips.hearstapps.com/hmg-prod/images/popular-puppy-questions-1639736471.jpg",
        "https://cdn.royalcanin-weshare-online.io/UCImMmgBaxEApS7LuQnZ/v2/eukanuba-market-image-puppy-beagle?w=5596&h=2317&rect=574,77,1850,1045&auto=compress,enhance",
        "https://www.usatoday.com/gcdn/presto/2020/03/17/USAT/c0eff9ec-e0e4-42db-b308-f748933229ee-XXX_ThinkstockPhotos-200460053-001.jpg?crop=1170,658,x292,y120&width=1170&height=585&format=pjpg&auto=webp"
    )

    var fact by networkDataStateOf<FactsResponse>()

    fun init() {
        if (fact !is NetworkDataState.Success) request()
    }

    fun request() {
        screenModelScope.launch {
            api.requests.getFacts().collect {
                fact = it
            }
        }
    }
}