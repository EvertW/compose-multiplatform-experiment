package ui.screens.settings.issue

import androidx.compose.runtime.Composable
import platform.Foundation.NSURL
import platform.UIKit.UIApplication

@Composable
actual fun IssueSubmitter(
    content: @Composable (
        submit: (subject: String, description: String) -> Unit,
    ) -> Unit
) {
    content.invoke { subject, description ->
        UIApplication.sharedApplication.openURL(
            NSURL(string = "mailto:?to=contact@evertwoud.com&subject=$subject&body=$description")
        )
    }
}