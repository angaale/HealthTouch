package com.golenyaeva.healthtouch.presentation.screen.splashscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.golenyaeva.healthtouch.presentation.screen.splashscreen.view.SplashScreenDisplay
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    SplashScreenDisplay()
    LaunchedEffect(key1 = Unit, block = {
        delay(1000)
        navController.navigate("main")
    })
}
