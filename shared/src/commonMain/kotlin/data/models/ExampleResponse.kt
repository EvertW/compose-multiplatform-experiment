package data.models

import kotlinx.serialization.Serializable

@Serializable
data class ExampleResponse(
    val facts: List<String>,
)
