package ui.screens.settings.issue

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.evertwoud.multiplatform.example.MR
import com.moriatsushi.insetsx.safeArea
import dev.icerock.moko.resources.compose.localized
import dev.icerock.moko.resources.desc.desc
import ui.library.buttons.MyButton
import ui.library.input.MyInput
import ui.library.text.MyText
import ui.library.topbar.MyTopBar
import ui.theme.MyTheme

class ReportIssueScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel<ReportIssueScreenModel>()
        val navigator = LocalNavigator.currentOrThrow
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeArea),
        ) {
            MyTopBar {
                navigator.pop()
            }
            Column(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(horizontal = MyTheme.dimensions.contentPadding)
            ) {
                MyText(
                    modifier = Modifier.fillMaxWidth(),
                    text = MR.strings.settings_report_issue.desc().localized(),
                    style = MyTheme.typography.title
                )
                Spacer(modifier = Modifier.height(4.dp))
                MyText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Mollit enim qui magna voluptate amet excepteur ex duis in Lorem pariatur cillum. Commodo fugiat nostrud consequat. Cupidatat labore nisi sit magna ex deserunt proident tempor nisi esse quis nulla excepteur veniam minim."
                )
                Spacer(modifier = Modifier.height(24.dp))
                MyInput(
                    modifier = Modifier.fillMaxWidth(),
                    label = MR.strings.settings_report_issue_subject_hint.desc().localized(),
                    value = screenModel.subject,
                ) { value ->
                    screenModel.subject = value
                }
                Spacer(modifier = Modifier.height(12.dp))
                MyInput(
                    modifier = Modifier.fillMaxWidth(),
                    label = MR.strings.settings_report_issue_description_hint.desc().localized(),
                    value = screenModel.description,
                    minLines = 5,
                    maxLines = Int.MAX_VALUE
                ) { value ->
                    screenModel.description = value
                }
                Spacer(modifier = Modifier.height(24.dp))
                MyButton(
                    text = MR.strings.generic_button_submit.desc().localized(),
                    enabled = screenModel.canSubmit
                ) {
                    handleSubmit(
                        subject = screenModel.subject.text,
                        description = screenModel.description.text
                    )
                    navigator.pop()
                }

                Spacer(modifier = Modifier.height(MyTheme.dimensions.contentPadding))
            }
        }
    }
}

expect fun handleSubmit(subject: String, description: String)