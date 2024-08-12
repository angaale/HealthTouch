package com.golenyaeva.healthtouch.presentation.screen.measure

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.golenyaeva.coreui.theme.White
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.presentation.screen.home.CardText
import com.golenyaeva.healthtouch.presentation.screen.home.PercentBarView
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@SuppressLint("PermissionLaunchedDuringComposition")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MeasureScreen(
    modifier: Modifier = Modifier,
    state: MeasureScreenUiModel,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.cardio)
    )
    val cameraPermissionState: PermissionState =
        rememberPermissionState(android.Manifest.permission.CAMERA)

    if (!cameraPermissionState.status.isGranted) {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier
                    .align(Alignment.Center),
                onClick = cameraPermissionState::launchPermissionRequest
            ) {
                Text(text = "Дать разрешение на использование камеры")
            }
        }
        return
    }

    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val context: Context = LocalContext.current
    val cameraController: LifecycleCameraController =
        remember { LifecycleCameraController(context) }

    AndroidView(
        modifier = Modifier
            .fillMaxSize(),
        factory = { context ->
            PreviewView(context).apply {
                layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                scaleType = PreviewView.ScaleType.FILL_START
            }.also { previewView ->
                previewView.controller = cameraController
                cameraController.bindToLifecycle(lifecycleOwner)
            }
        }
    )

    Column(
        modifier = modifier
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
