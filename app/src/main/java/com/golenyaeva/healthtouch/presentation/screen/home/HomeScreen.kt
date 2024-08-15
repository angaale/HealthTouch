package com.golenyaeva.healthtouch.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeUiModel
import com.golenyaeva.healthtouch.presentation.screen.home.view.HomeScreenDisplay
import com.golenyaeva.healthtouch.presentation.screen.home.view.HomeScreenNoItems

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    homeViewModel: HomeViewModel,
) {
    val viewState =
        homeViewModel.homeViewState.observeAsState(initial = homeViewModel.homeViewState)

    when (val state = viewState.value) {
        is HomeUiModel.Display -> HomeScreenDisplay(state = state)
        is HomeUiModel.NoItems -> HomeScreenNoItems(state = state)
        else -> Unit
    }
}
