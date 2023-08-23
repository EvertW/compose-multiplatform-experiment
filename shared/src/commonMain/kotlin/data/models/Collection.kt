package data.models

import kotlinx.serialization.Serializable

@Serializable
data class Collection(
    val id: Long,
    val name: String,
    val description: String,
    val category: String,
)
