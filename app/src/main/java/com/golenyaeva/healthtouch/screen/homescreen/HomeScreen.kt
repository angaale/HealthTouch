package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.golenyaeva.healthtouch.domain.CardActivitiesModel
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
            modifier = Modifier.padding(top = 150.dp),
        ) {
            state.tabs.forEach { tab ->
                MainTabView(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 14.dp),
                    state = tab,
                    content = {
                        when (tab) {
                            is MainTabViewUiModel.MeasuringTab -> MeasureBpmHrv(
                                state = tab.measuring
                            )

                            is MainTabViewUiModel.SelfFeelingTab -> SelfFeeling(state = tab.selfFeeling)
                            is MainTabViewUiModel.CardsActivitiesTab -> {
                                LazyRow(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                ) {
                                    items(tab.activitiesModel) { card ->
                                        CardsActivities(
                                            state = card
                                        )
                                    }
                                }
                            }
                        }
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
                MainTabViewUiModel.CardsActivitiesTab(
                    subtitle = "29.11.2024",
                    activitiesModel = listOf(
                        CardActivitiesModel.Excitement(),
                        CardActivitiesModel.Run()
                    )
                ),
            )
        )
    )
}
