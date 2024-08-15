package com.golenyaeva.healthtouch.presentation.screen.splashscreen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.golenyaeva.coreui.theme.LightGreen
import com.golenyaeva.healthtouch.R

@Composable
fun SplashScreenDisplay(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color = LightGreen)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun SplashScreenDisplayPreview() {
    SplashScreenDisplay()
}
