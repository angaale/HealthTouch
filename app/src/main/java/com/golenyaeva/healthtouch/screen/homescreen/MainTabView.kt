package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
        Spacer(modifier = Modifier.height(16.dp))
        when (state) {
            is MainTabViewUiModel.MeasuringTab -> MeasureBpmHrv(
                state = state.measuring
            )

            is MainTabViewUiModel.SelfFeelingTab -> SelfFeeling(state = state.selfFeeling)
            is MainTabViewUiModel.CardsActivitiesTab -> {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(state.activitiesModel) { card ->
                        CardsActivities(
                            state = card
                        )
                    }
                }
            }

            is MainTabViewUiModel.CardsRecommendationsTab -> {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(state.activitiesModel) { card ->
                        CardsActivities(
                            state = card
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        HorizontalDivider(thickness = 1.dp)
    }
}

@Preview
@Composable
fun MainTabViewPreview() = MainTabView(
    state = MainTabViewUiModel.MeasuringTab(
        titleRes = R.string.main_tab_title_measure,
        subtitle = "29.11.2024",
        buttonTextRes = R.string.main_tab_button_measure,
        measuring = MeasuringBpmHrvUiModel(
            bpm = MeasuringUiModel.BPM(86),
            hrv = MeasuringUiModel.HRV(164),
        ),
    ),
)
