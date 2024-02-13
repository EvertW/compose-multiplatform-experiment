package ui.screens.settings.issue

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual fun handleSubmit(subject: String, description: String) {
    val url =
        NSURL(string = "mailto:?to=contact@evertwoud.com&subject=$subject&body=$description")
    if (UIApplication.sharedApplication.canOpenURL(url)) {
        UIApplication.sharedApplication.openURL(url)
    } else {
        print("Can't open url on this device")
    }
}