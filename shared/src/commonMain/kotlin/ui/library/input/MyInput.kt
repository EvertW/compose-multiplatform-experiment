package ui.library.input

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import ui.library.text.MyText
import ui.theme.MyTheme

@Composable
fun MyInput(
    modifier: Modifier = Modifier,
    label: String,
    value: TextFieldValue,
    hint: String? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Sentences,
    ),
    maxLines: Int = 1,
    minLines: Int = 1,
    onValueChange: (TextFieldValue) -> Unit
) {
    BasicTextField(
        modifier = modifier.animateContentSize(),
        onValueChange = onValueChange,
        value = value,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        decorationBox = { field ->
            Column(
                modifier = Modifier
                    .background(MyTheme.colors.background)
                    .border(
                        width = 2.dp,
                        color = MyTheme.colors.text,
                    )
                    .padding(12.dp),
            ) {
                if (value.text.isNotEmpty() || hint != null) {
                    MyText(
                        text = label,
                        style = MyTheme.typography.label
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                }
                Box(modifier = Modifier.fillMaxWidth()) {
                    field()
                    if (value.text.isEmpty()) {
                        MyText(
                            text = hint ?: label,
                            style = MyTheme.typography.input,
                            color = MyTheme.colors.text.copy(alpha = 0.7F),
                        )
                    }
                }
            }
        },
        cursorBrush = SolidColor(MyTheme.colors.primary),
        textStyle = MyTheme.typography.input.copy(
            color = MyTheme.colors.text
        ),
        singleLine = maxLines == 1,
        maxLines = maxLines,
        minLines = minLines
    )
}