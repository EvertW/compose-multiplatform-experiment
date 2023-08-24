package ui.screens.settings.issue

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@Composable
actual fun IssueSubmitter(
    content: @Composable (
        submit: (subject: String, description: String) -> Unit,
    ) -> Unit
) {
    val context = LocalContext.current
    content.invoke { subject, description ->
        val emailIntent = Intent(
            Intent.ACTION_SENDTO,
            Uri.parse("mailto:?to=contact@evertwoud.com&subject=$subject&body=$description")
        )
        context.startActivity(emailIntent)
    }
}