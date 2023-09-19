package ui.screens.settings.issue

import androidx.compose.runtime.Composable
import kotlinx.cinterop.BetaInteropApi
import platform.Foundation.NSURL
import platform.UIKit.UIApplication

@OptIn(BetaInteropApi::class)
@Composable
actual fun IssueSubmitter(
    content: @Composable (
        submit: (subject: String, description: String) -> Unit,
    ) -> Unit
) {
    content.invoke { subject, description ->
        val url =
            NSURL(string = "mailto:?to=contact@evertwoud.com&subject=$subject&body=$description")
        if (UIApplication.sharedApplication.canOpenURL(url)) {
            UIApplication.sharedApplication.openURL(url)
        } else {
            print("Can't open url on this device")
        }
    }
}