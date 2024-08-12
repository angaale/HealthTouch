package com.golenyaeva.coreui.kit.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.core_ui.R
import com.golenyaeva.coreui.theme.Primary
import com.golenyaeva.coreui.theme.TextDisable
import com.golenyaeva.coreui.theme.White

@Composable
fun ButtonView(
    modifier: Modifier = Modifier,
    state: ButtonViewUiModel,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp),
        onClick = {},
        enabled = state.enabled,
        colors = ButtonColors(
            contentColor = White,
            containerColor = Primary,
            disabledContentColor = White,
            disabledContainerColor = TextDisable,
        ),
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(
                color = White
            )
        } else {
            Text(text = stringResource(id = state.textButtonRes))
        }
    }
}

@Preview
@Composable
fun ButtonViewPrimaryPreview() = ButtonView(
    state = ButtonViewUiModel(
        textButtonRes = R.string.save,
        isLoading = false,
        style = ButtonViewUiModel.Style.PRIMARY
    )
)

@Preview
@Composable
fun ButtonViewLoadingPreview() = ButtonView(
    state = ButtonViewUiModel(
        textButtonRes = R.string.save,
        isLoading = true,
        style = ButtonViewUiModel.Style.SECONDARY
    )
)

@Preview
@Composable
fun ButtonViewDisabledPreview() = ButtonView(
    state = ButtonViewUiModel(
        textButtonRes = R.string.save,
        isLoading = false,
        enabled = false,
        style = ButtonViewUiModel.Style.SECONDARY
    )
)
