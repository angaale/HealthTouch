package com.golenyaeva.healthtouch.presentation.screen.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.coreui.kit.maintab.MainTabView
import com.golenyaeva.coreui.kit.maintab.MainTabViewUiModel
import com.golenyaeva.coreui.kit.measuringbpmhrv.MeasuringBpmHrvUiModel
import com.golenyaeva.coreui.kit.measuring.MeasuringUiModel
import com.golenyaeva.coreui.kit.selffeeling.SelfFeelingUiModel
import com.golenyaeva.coreui.kit.button.ButtonView
import com.golenyaeva.coreui.kit.button.ButtonViewUiModel
import com.golenyaeva.coreui.theme.White

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    state: ResultScreenUiModel,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = White),
    ) {
        ResultTopBarView(date = state.date)
        LazyColumn(
            modifier = Modifier.padding(top = 150.dp),
        ) {
            items(state.tabs) { tab ->
                MainTabView(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 14.dp),
                    state = tab,
                )
            }
        }
        ButtonView(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp),
            state = ButtonViewUiModel(
                textButtonRes = R.string.result_screen_button_title,
            )
        )
    }
}

@Preview
@Composable
fun ResultScreenPreview() = ResultScreen(
    state = ResultScreenUiModel(
        date = "28.07.2024",
        tabs = listOf(
            MainTabViewUiModel.MeasuringTab(
                titleRes = R.string.result_screen_measuring_title,
                subtitle = "29.11.2024",
                buttonTextRes = null,
                measuring = MeasuringBpmHrvUiModel(
                    bpm = MeasuringUiModel.BPM(86),
                    hrv = MeasuringUiModel.HRV(164),
                ),
            ),
            MainTabViewUiModel.SelfFeelingTab(
                subtitle = "29.11.2024",
                buttonTextRes = null,
                selfFeeling = SelfFeelingUiModel.Good(
                    percent = 86,
                ),
            ),
        )
    )
)