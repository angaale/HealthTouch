package com.golenyaeva.healthtouch.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.golenyaeva.coreui.kit.cardactivity.CardActivitiesModel
import com.golenyaeva.coreui.kit.maintab.MainTabView
import com.golenyaeva.coreui.kit.maintab.MainTabViewUiModel
import com.golenyaeva.coreui.kit.measuring.MeasuringUiModel
import com.golenyaeva.coreui.kit.measuringbpmhrv.MeasuringBpmHrvUiModel
import com.golenyaeva.coreui.kit.selffeeling.SelfFeelingUiModel
import com.golenyaeva.coreui.theme.TextDisable
import com.golenyaeva.coreui.theme.White
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeScreenUiModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.Intent
import com.golenyaeva.healthtouch.presentation.screen.home.view.HomeTopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeScreenUiModel,
    navController: NavController? = null,
    dispatch: (Intent) -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = White),
    ) {
        HomeTopBar(
            state = state.user
        )
        if (state.tabs.isEmpty())
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.home_screen_empty_title),
                    fontSize = 12.sp,
                    color = TextDisable,
                    fontWeight = FontWeight(400),
                )
            }
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
fun HomeScreenNoItemsPreview() = HomeScreen(
    state = HomeScreenUiModel(
        user = UserModel(
            firstName = "Евгений",
            lastName = "Онегин",
            image = "image",
            height = 100,
            weight = 100,
        ),
    )
)

@Preview
@Composable
fun HomeScreenPreview1() = HomeScreen(
    state = HomeScreenUiModel(
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

@Preview
@Composable
fun HomeScreenPreview2() = HomeScreen(
    state = HomeScreenUiModel(
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
