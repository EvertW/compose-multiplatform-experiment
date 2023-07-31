package data.models

import kotlinx.serialization.Serializable

@Serializable
data class Trip(
    val id: Long,
    val destination: String,
    val country: String,
    val startDate: Long,
    val endDate: Long? = null,
    val supplies: List<Supply> = emptyList(),
) {
    @Serializable
    data class Supply(
        val name: String,
        val checked: Boolean,
    )
}