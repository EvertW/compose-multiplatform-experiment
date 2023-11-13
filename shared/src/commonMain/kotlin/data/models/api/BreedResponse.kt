package data.models.api

import kotlinx.serialization.Serializable

@Serializable
data class BreedResponse(
    val id: String,
    val name: String,
)
