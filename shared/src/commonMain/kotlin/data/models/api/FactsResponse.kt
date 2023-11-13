package data.models.api

import kotlinx.serialization.Serializable

@Serializable
data class FactsResponse(
    val facts: List<String>,
)
