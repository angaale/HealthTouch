package com.golenyaeva.healthtouch.screen.onboardingscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.ui.kit.PageIndicator
import com.golenyaeva.healthtouch.ui.theme.Primary
import com.golenyaeva.healthtouch.ui.theme.TextPrimary
import com.golenyaeva.healthtouch.ui.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    state: OnboardingUIModel,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .weight(1f),
        ) {
            state.imageRes?.let {
                Image(
                    modifier = Modifier
                        .padding(bottom = 32.dp),
                    painter = painterResource(id = state.imageRes),
                    contentDescription = null,
                )
            }
        }
        HorizontalDivider(thickness = 1.dp, color = Primary)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f),
        ) {
            state.title?.let { titleId ->
                Text(
                    modifier = Modifier.padding(top = 32.dp),
                    text = stringResource(id = titleId),
                    color = TextPrimary,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                )
            }
          state.title?.let { descriptionId ->
              Text(
                  modifier = Modifier.padding(top = 24.dp),
                  text = stringResource(id = descriptionId),
                  color = TextPrimary,
                  fontSize = 18.sp,
                  textAlign = TextAlign.Center,
              )
          }

            val numberOfPages = 3
            val (selectedPage, setSelectedPage) = remember {
                mutableStateOf(state.currentPage)
            }
            PageIndicator(
                modifier = Modifier.padding(84.dp),
                numberOfPages = numberOfPages,
                selectedPage = selectedPage,
                defaultRadius = 8.dp,
                selectedLength = 24.dp,
                space = 4.dp,
                animationDurationInMillis = 1000,
            )
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview1() {
    OnboardingScreen(
        state = OnboardingUIModel(
            imageRes = R.drawable.ic_onboarding_1,
            title = R.string.onboarding_screen_1_title,
            description = R.string.onboarding_screen_1_description,
            currentPage = 0,
        )
    )
}

@Preview
@Composable
fun OnboardingScreenPreview2() {
    OnboardingScreen(
        state = OnboardingUIModel(
            imageRes = R.drawable.ic_onboarding_2,
            title = R.string.onboarding_screen_2_title,
            description = R.string.onboarding_screen_2_description,
            currentPage = 1,
        )
    )
}

@Preview
@Composable
fun OnboardingScreenPreview3() {
    OnboardingScreen(
        state = OnboardingUIModel(
            imageRes = R.drawable.ic_onboarding_3,
            title = R.string.onboarding_screen_3_title,
            description = R.string.onboarding_screen_3_description,
            currentPage = 2,
        )
    )
}
