package com.golenyaeva.healthtouch.screen.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.golenyaeva.healthtouch.data.UserModel
import com.golenyaeva.healthtouch.ui.theme.White

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeUIModel,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = White),
    ) {
        HomeTopBar(
            state = state.user
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview1() {
    HomeScreen(
        state = HomeUIModel(
            user = UserModel(
                firstName = "Евгений",
                lastName = "Онегин",
                image = "image"
            )
        )
    )
}
