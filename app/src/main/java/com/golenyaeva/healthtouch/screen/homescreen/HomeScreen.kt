package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.ui.theme.White

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeUiModel,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = White),
    ) {
        HomeTopBar(
            state = state.user
        )
        Column(
            modifier = Modifier.padding(top = 150.dp)
        ) {
            state.tabs.forEach { tab ->
                MainTabView(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 14.dp),
                    state = tab,
                    content = {
                        MeasureBpmHrv(
                            state = MeasuringBpmHrvUiModel(
                                bpm = MeasuringUiModel.BPM(86),
                                hrv = MeasuringUiModel.HRV(164),
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        state = HomeUiModel(
            user = UserModel(
                firstName = "Евгений",
                lastName = "Онегин",
                image = "image"
            ),
            tabs = listOf(
                MainTabViewUiModel.Measuring(
                    titleRes = R.string.main_tab_title_measure,
                    subtitle = "29.11.2024",
                    buttonTextRes = R.string.main_tab_button_measure,
                    measuring = MeasuringBpmHrvUiModel(
                        bpm = MeasuringUiModel.BPM(86),
                        hrv = MeasuringUiModel.HRV(164),
                    ),
                ),
                MainTabViewUiModel.Measuring(
                    titleRes = R.string.main_tab_title_measure,
                    subtitle = "29.11.2024",
                    buttonTextRes = R.string.main_tab_button_measure,
                    measuring = MeasuringBpmHrvUiModel(
                        bpm = MeasuringUiModel.BPM(86),
                        hrv = MeasuringUiModel.HRV(164),
                    ),
                ),
                MainTabViewUiModel.Measuring(
                    titleRes = R.string.main_tab_title_measure,
                    subtitle = "29.11.2024",
                    buttonTextRes = R.string.main_tab_button_measure,
                    measuring = MeasuringBpmHrvUiModel(
                        bpm = MeasuringUiModel.BPM(86),
                        hrv = MeasuringUiModel.HRV(164),
                    ),
                ),
                MainTabViewUiModel.Measuring(
                    titleRes = R.string.main_tab_title_measure,
                    subtitle = "29.11.2024",
                    buttonTextRes = R.string.main_tab_button_measure,
                    measuring = MeasuringBpmHrvUiModel(
                        bpm = MeasuringUiModel.BPM(86),
                        hrv = MeasuringUiModel.HRV(164),
                    ),
                ),
            )
        )
    )
}
