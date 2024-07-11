package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R

@Composable
fun MainTabView(
    modifier: Modifier = Modifier,
    state: MainTabViewUiModel,
    content: @Composable() (() -> Unit) = { }
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row {
            Text(
                text = stringResource(id = state.titleRes),
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
            )
            val buttonText = state.buttonTextRes
            buttonText?.let {
                Text(
                    text = stringResource(id = buttonText),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = state.subtitle,
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
        )
        Spacer(modifier = Modifier.height(8.dp))
        content()
        Spacer(modifier = Modifier.height(18.dp))
        HorizontalDivider(thickness = 1.dp)
    }
}

@Preview
@Composable
fun MainTabViewPreview() = MainTabView(
    state = MainTabViewUiModel.Measuring(
        titleRes = R.string.main_tab_title_measure,
        subtitle = "29.11.2024",
        buttonTextRes = R.string.main_tab_button_measure,
        measuring = MeasuringBpmHrvUiModel(
            bpm = MeasuringUiModel.BPM(86),
            hrv = MeasuringUiModel.HRV(164),
        ),
    ),
    content = {
        MeasureBpmHrv(
            state = MeasuringBpmHrvUiModel(
                bpm = MeasuringUiModel.BPM(86),
                hrv = MeasuringUiModel.HRV(164),
            )
        )
    }
)
