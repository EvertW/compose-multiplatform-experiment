package ui.screens.settings.issue

import androidx.compose.runtime.Composable

@Composable
expect fun IssueSubmitter(
    content: @Composable (
        submit: (subject: String, description: String) -> Unit,
    ) -> Unit
)