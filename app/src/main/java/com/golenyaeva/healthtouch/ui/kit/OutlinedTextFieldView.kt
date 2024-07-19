package com.golenyaeva.healthtouch.ui.kit

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.ui.theme.Primary
import com.golenyaeva.healthtouch.ui.theme.TextFieldDefault
import com.golenyaeva.healthtouch.ui.theme.TextPrimary

@Composable
fun OutlinedTextFieldView(
    modifier: Modifier = Modifier,
    value: String,
    @StringRes labelRes: Int? = null,
    @StringRes supportingTextRes: Int? = null,
) {
    val label = labelRes?.let { stringResource(id = it) } ?: ""
    val supportingText = supportingTextRes?.let { stringResource(id = it) } ?: ""
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = {},
        label = { Text(text = label) },
        supportingText = { Text(text = supportingText) },
        colors = OutlinedTextFieldDefaults.colors().copy(
            focusedTextColor = TextPrimary,
            unfocusedTextColor = TextFieldDefault,
            focusedLabelColor = Primary,
            unfocusedLabelColor = TextFieldDefault,
            focusedSupportingTextColor = Primary,
            unfocusedSupportingTextColor = TextFieldDefault,
            focusedIndicatorColor = Primary,
            unfocusedIndicatorColor = TextFieldDefault,
        )
    )
}

@Preview
@Composable
fun OutlinedTextFieldViewPreview() = OutlinedTextFieldView(
    value = "Text",
    labelRes = R.string.profile_screen_name_label,
    supportingTextRes = R.string.profile_screen_name_supporting,
)
