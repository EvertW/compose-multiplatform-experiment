package ui.screens.settings.issue

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import cafe.adriel.voyager.core.model.ScreenModel


class ReportIssueScreenModel : ScreenModel {
    var subject by mutableStateOf(TextFieldValue())
    var description by mutableStateOf(TextFieldValue())

    val canSubmit by derivedStateOf {
        subject.text.isNotBlank() && description.text.isNotBlank()
    }
}

