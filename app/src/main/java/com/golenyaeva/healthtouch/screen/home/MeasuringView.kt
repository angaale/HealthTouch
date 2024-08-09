@file:JvmName("MeasuringUiModelKt")

package com.golenyaeva.healthtouch.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.coreui.theme.LightGreen
import com.golenyaeva.coreui.theme.Primary

@Composable
fun Measuring(
    modifier: Modifier = Modifier,
    state: MeasuringUiModel,
) {
    Box(
        modifier = modifier
            .height(72.dp)
            .clip(
                RoundedCornerShape(
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp,
                    topEnd = 24.dp,
                    topStart = 24.dp,
                )
            )
            .background(color = LightGreen),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.padding(
                start = 12.dp,
                end = 12.dp,
                top = 10.dp,
                bottom = 10.dp,
            )
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.ic_ekg),
                contentDescription = ""
            )
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Image(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = ""
                )
                val valueRes = when (state) {
                    is MeasuringUiModel.BPM -> R.string.last_measure_bpm
                    is MeasuringUiModel.HRV -> R.string.last_measure_hrv
                }
                Text(
                    fontSize = 12.sp,
                    color = Primary,
                    fontWeight = FontWeight(500),
                    modifier = modifier.padding(top = 8.dp),
                    text = stringResource(
                        id = valueRes,
                        state.value
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
fun MeasurePreview() {
    Measuring(
        state = MeasuringUiModel.BPM(86)
    )
}
