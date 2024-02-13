package ui.screens.settings.issue

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import util.ApplicationContextProvider

actual fun handleSubmit(subject: String, description: String) {
    val emailIntent = Intent(
        Intent.ACTION_SENDTO,
        Uri.parse("mailto:?to=contact@evertwoud.com&subject=$subject&body=$description")
    ).apply {
        flags += FLAG_ACTIVITY_NEW_TASK
    }
    ApplicationContextProvider.applicationContext.startActivity(emailIntent)
}