package com.golenyaeva.healthtouch.presentation.screen.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.coreui.kit.cardactivity.CardActivitiesModel
import com.golenyaeva.coreui.kit.maintab.MainTabView
import com.golenyaeva.coreui.kit.maintab.MainTabViewUiModel
import com.golenyaeva.coreui.kit.measuring.MeasuringUiModel
import com.golenyaeva.coreui.kit.measuringbpmhrv.MeasuringBpmHrvUiModel
import com.golenyaeva.coreui.kit.selffeeling.SelfFeelingUiModel
import com.golenyaeva.coreui.theme.White
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeUiModel
import drawable.NavigationBarView

@Composable
fun HomeScreenDisplay(
    modifier: Modifier = Modifier,
    state: HomeUiModel.Display,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = White),
    ) {
        HomeTopBar(
            state = state.user
        )
        NavigationBarView(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
        Column(
            modifier = Modifier.padding(top = 150.dp),
        ) {
            state.tabs.forEach { tab ->
                MainTabView(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 14.dp),
                    state = tab,
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenDisplayPreview1() {
    HomeScreenDisplay(
        state = HomeUiModel.Display(
            user = UserModel(
                firstName = "Евгений",
                lastName = "Онегин",
                image = "image",
                height = 100,
                weight = 100,
            ),
            tabs = listOf(
                MainTabViewUiModel.MeasuringTab(
                    subtitle = "29.11.2024",
                    measuring = MeasuringBpmHrvUiModel(
                        bpm = MeasuringUiModel.BPM(86),
                        hrv = MeasuringUiModel.HRV(164),
                    ),
                ),
                MainTabViewUiModel.SelfFeelingTab(
                    subtitle = "29.11.2024",
                    selfFeeling = SelfFeelingUiModel.Good(
                        percent = 86,
                    ),
                ),
            )
        )
    )
}

@Preview
@Composable
fun HomeScreenDisplayPreview2() {
    HomeScreenDisplay(
        state = HomeUiModel.Display(
            user = UserModel(
                firstName = "Евгений",
                lastName = "Онегин",
                image = "image",
                height = 100,
                weight = 100,
            ),
            tabs = listOf(
                MainTabViewUiModel.CardsActivitiesTab(
                    subtitle = "29.11.2024",
                    activitiesModel = listOf(
                        CardActivitiesModel.Excitement(),
                        CardActivitiesModel.Run()
                    )
                ),
                MainTabViewUiModel.CardsRecommendationsTab(
                    subtitle = stringResource(id = com.golenyaeva.core_ui.R.string.main_tab_subtitle_recommendation_activities),
                    activitiesModel = listOf(
                        CardActivitiesModel.Walk(),
                        CardActivitiesModel.Yoga()
                    )
                ),
            )
        )
    )
}
