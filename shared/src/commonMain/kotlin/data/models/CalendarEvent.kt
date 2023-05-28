package data.models

data class CalendarEvent(
    val id: Long,
    val title: String,
    val speaker: String,
    val description: String,
    val date: Long,
)