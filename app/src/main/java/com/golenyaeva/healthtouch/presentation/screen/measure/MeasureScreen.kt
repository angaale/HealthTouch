package com.golenyaeva.healthtouch.presentation.screen.measure

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.golenyaeva.healthtouch.R
import com.golenyaeva.coreui.theme.White
import com.golenyaeva.healthtouch.presentation.screen.home.CardText
import com.golenyaeva.healthtouch.presentation.screen.home.PercentBarView

@Composable
fun MeasureScreen(
    modifier: Modifier = Modifier,
    state: MeasureScreenUiModel,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.cardio)
    )
    Column(
        modifier = modifier
            .background(Color.Red)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                color = White,
                fontWeight = FontWeight(400),
                text = stringResource(
                    id = R.string.measure_screen_bpm,
                    state.pulse
                )
            )
            LottieAnimation(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                alignment = Alignment.BottomCenter,
                iterations = LottieConstants.IterateForever,
                contentScale = ContentScale.FillWidth,
                composition = composition
            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            CardText(
                modifier = Modifier.padding(top = 24.dp),
                text = stringResource(id = R.string.measure_screen_advice),
                textSize = 20,
            )
            CardText(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(
                    id = R.string.measure_screen_percents,
                    (state.progress * 100).toInt()
                ),
                textSize = 32,
            )
            PercentBarView(
                modifier = Modifier
                    .padding(top = 24.dp),
                percent = state.progress
            )
        }
    }

}

@Preview
@Composable
fun MeasureScreenPreview() = MeasureScreen(
    state = MeasureScreenUiModel(
        pulse = 129,
        progress = 0.02f
    )
)
