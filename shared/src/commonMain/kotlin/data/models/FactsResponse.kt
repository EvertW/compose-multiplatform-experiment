package data.models

import kotlinx.serialization.Serializable

@Serializable
data class FactsResponse(
    val facts: List<String>,
)
