package com.golenyaeva.healthtouch.presentation.screen.main.navigation

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.golenyaeva.healthtouch.presentation.screen.main.model.MainTabRoute
import com.golenyaeva.healthtouch.presentation.screen.measure.MeasureScreen
import com.golenyaeva.healthtouch.presentation.screen.measure.MeasureViewModel
import com.golenyaeva.healthtouch.presentation.screen.measure.model.MeasureScreenUiModel

fun NavGraphBuilder.measureFlow(
    navController: NavController,
) {
    navigation(startDestination = "measure", route = MainTabRoute.Measure.route) {
        composable("measure") {
            val viewModel: MeasureViewModel = hiltViewModel()
            val state: MeasureScreenUiModel = viewModel.uiState.collectAsState().value
            MeasureScreen(
                state = state,
            )
        }
    }
}
