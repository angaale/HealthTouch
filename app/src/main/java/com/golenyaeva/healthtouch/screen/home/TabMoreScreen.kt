package com.golenyaeva.healthtouch.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.ui.theme.White

@Composable
fun TabMoreScreen(
    modifier: Modifier = Modifier,
    state: TabMoreUiModel,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = White),
    ) {
        NavigationBarView(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 16.dp),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(16.dp))
            state.tabs.forEach { tab ->
                MainTabView(
                    state = tab
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun TabMoreScreenPreview() = TabMoreScreen(
    state = TabMoreUiModel(
        listOf(
            MainTabViewUiModel.MeasuringTab(
                subtitle = "28.11.2023",
                buttonTextRes = null,
                measuring = MeasuringBpmHrvUiModel(
                    bpm = MeasuringUiModel.BPM(100),
                    hrv = MeasuringUiModel.HRV(100),
                )
            ),
            MainTabViewUiModel.MeasuringTab(
                subtitle = "27.11.2023",
                buttonTextRes = null,
                measuring = MeasuringBpmHrvUiModel(
                    bpm = MeasuringUiModel.BPM(100),
                    hrv = MeasuringUiModel.HRV(100),
                )
            ),
            MainTabViewUiModel.MeasuringTab(
                subtitle = "26.11.2023",
                buttonTextRes = null,
                measuring = MeasuringBpmHrvUiModel(
                    bpm = MeasuringUiModel.BPM(100),
                    hrv = MeasuringUiModel.HRV(100),
                )
            ),
            MainTabViewUiModel.MeasuringTab(
                subtitle = "25.11.2023",
                buttonTextRes = null,
                measuring = MeasuringBpmHrvUiModel(
                    bpm = MeasuringUiModel.BPM(100),
                    hrv = MeasuringUiModel.HRV(100),
                )
            )
        )
    )
)
