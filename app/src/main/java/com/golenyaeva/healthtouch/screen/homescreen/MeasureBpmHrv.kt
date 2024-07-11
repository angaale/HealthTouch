package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MeasureBpmHrv(
    state: MeasureBpmHrvUiModel
) {
    Row {
        Measuring(state = state.bpm)
        Spacer(modifier = Modifier.width(8.dp))
        Measuring(state = state.hrv)
    }
}

@Preview
@Composable
fun MeasureBpmHrvPreview() {
    MeasureBpmHrv(
        state = MeasureBpmHrvUiModel(
            bpm = MeasureUiModel.BPM(86),
            hrv = MeasureUiModel.HRV(164),
        )
    )
}
