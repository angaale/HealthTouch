package com.golenyaeva.healthtouch.presentation.screen.main.navigation

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.golenyaeva.healthtouch.presentation.screen.home.HomeScreen
import com.golenyaeva.healthtouch.presentation.screen.home.HomeViewModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeScreenUiModel
import com.golenyaeva.healthtouch.presentation.screen.main.model.MainTabRoute

fun NavGraphBuilder.mainFlow(
    navController: NavController,
) {
    navigation(startDestination = "home", route = MainTabRoute.Home.route) {
        composable("home") {
            val viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
            val state: HomeScreenUiModel = viewModel.uiState.collectAsState().value
            HomeScreen(
                state = state,
                navController = navController,
                dispatch = viewModel::handleIntent
            )
        }
    }
}
