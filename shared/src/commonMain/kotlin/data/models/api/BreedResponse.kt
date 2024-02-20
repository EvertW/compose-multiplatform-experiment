package data.models.api

import kotlinx.serialization.Serializable

@Serializable
data class BreedResponse(
    val id: String,
    val name: String,
    val temperament: String?,
    val origin: String?,
    val life_span: String?,
    val bred_for: String?,
    val reference_image_id: String?,
) {
    val image
        get() = reference_image_id?.let { "https://cdn2.thedogapi.com/images/$it.jpg" }.orEmpty()
}
