package ui.screens.calendar

import androidx.compose.runtime.mutableStateListOf
import cafe.adriel.voyager.core.model.ScreenModel
import data.models.CalendarEvent

class CalendarScreenModel : ScreenModel {

    val talks = mutableStateListOf<CalendarEvent>()

    init {
        talks.addAll(
            listOf(
                CalendarEvent(
                    id = 1,
                    title = "Developing for multiple platforms using Jetpack Compose",
                    speaker = "Evert Woud",
                    description = "Dolore exercitation eiusmod labore Lorem veniam sit pariatur laborum ex id. Labore nostrud tempor ut ex veniam et labore proident occaecat veniam. Enim ut ad consectetur nisi nostrud et.",
                    date = 0L
                ),
                CalendarEvent(
                    id = 2,
                    title = "Basics of Jetpack Compose",
                    speaker = "Evert Woud",
                    description = "Dolore exercitation eiusmod labore Lorem veniam sit pariatur laborum ex id. Labore nostrud tempor ut ex veniam et labore proident occaecat veniam. Enim ut ad consectetur nisi nostrud et.",
                    date = 0L
                ),
                CalendarEvent(
                    id = 3,
                    title = "Kotlin for Web",
                    speaker = "Evert Woud",
                    description = "Dolore exercitation eiusmod labore Lorem veniam sit pariatur laborum ex id. Labore nostrud tempor ut ex veniam et labore proident occaecat veniam. Enim ut ad consectetur nisi nostrud et.",
                    date = 0L
                ),
                CalendarEvent(
                    id = 4,
                    title = "Future of Jetpack Compose",
                    speaker = "Evert Woud",
                    description = "Dolore exercitation eiusmod labore Lorem veniam sit pariatur laborum ex id. Labore nostrud tempor ut ex veniam et labore proident occaecat veniam. Enim ut ad consectetur nisi nostrud et.",
                    date = 0L
                ),
                CalendarEvent(
                    id = 5,
                    title = "Kotlin Multiplatform",
                    speaker = "Evert Woud",
                    description = "Dolore exercitation eiusmod labore Lorem veniam sit pariatur laborum ex id. Labore nostrud tempor ut ex veniam et labore proident occaecat veniam. Enim ut ad consectetur nisi nostrud et.",
                    date = 0L
                ),
            )
        )
    }
}