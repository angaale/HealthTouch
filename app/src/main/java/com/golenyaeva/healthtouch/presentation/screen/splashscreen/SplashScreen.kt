package com.golenyaeva.healthtouch.presentation.screen.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.golenyaeva.coreui.theme.LightGreen
import com.golenyaeva.healthtouch.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
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
    LaunchedEffect(key1 = Unit, block = {
        delay(1000)
        navController?.popBackStack()
        navController?.navigate("main")
    })
}
