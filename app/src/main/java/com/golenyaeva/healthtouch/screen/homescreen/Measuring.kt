@file:JvmName("MeasureUiModelKt")

package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.ui.theme.LightGreen
import com.golenyaeva.healthtouch.ui.theme.Primary

@Composable
fun Measuring(
    modifier: Modifier = Modifier,
    state: MeasureUiModel,
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(
                RoundedCornerShape(
                    bottomStart = 24.dp,
                    bottomEnd = 24.dp,
                    topEnd = 24.dp,
                    topStart = 24.dp,
                )
            )
            .background(color = LightGreen),
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
                painter = painterResource(id = R.drawable.ic_cardio),
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
                    is MeasureUiModel.BPM -> R.string.last_measure_bpm
                    is MeasureUiModel.HRV -> R.string.last_measure_hrv
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
        state = MeasureUiModel.BPM(86)
    )
}
