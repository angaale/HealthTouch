package com.golenyaeva.coreui.kit.measuringbpmhrv

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.coreui.kit.measuring.MeasuringUiModel
import com.golenyaeva.coreui.kit.measuring.Measuring

@Composable
fun MeasureBpmHrv(
    modifier: Modifier = Modifier,
    state: MeasuringBpmHrvUiModel
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Measuring(
            modifier = Modifier.weight(1f),
            state = state.bpm
        )
        Spacer(modifier = Modifier.width(8.dp))
        Measuring(
            modifier = Modifier.weight(1f),
            state = state.hrv
        )
    }
}

@Preview
@Composable
fun MeasureBpmHrvPreview() {
    MeasureBpmHrv(
        state = MeasuringBpmHrvUiModel(
            bpm = MeasuringUiModel.BPM(86),
            hrv = MeasuringUiModel.HRV(164),
        )
    )
}
