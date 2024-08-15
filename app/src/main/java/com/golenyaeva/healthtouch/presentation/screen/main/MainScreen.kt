package com.golenyaeva.healthtouch.presentation.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.golenyaeva.healthtouch.presentation.screen.main.model.Intent
import com.golenyaeva.healthtouch.presentation.screen.main.model.MainScreenUiModel
import com.golenyaeva.healthtouch.presentation.screen.main.navigation.chatFlow
import com.golenyaeva.healthtouch.presentation.screen.main.navigation.mainFlow
import com.golenyaeva.healthtouch.presentation.screen.main.navigation.measureFlow
import com.golenyaeva.healthtouch.presentation.screen.main.view.NavigationBarView

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    state: MainScreenUiModel,
    dispatch: (Intent) -> Unit = {},
) {
    val childNavController = rememberNavController()
    Column(
        modifier = modifier,
    ) {
        Box(modifier = Modifier.weight(1f)) {
            NavHost(
                navController = childNavController,
                startDestination = state.selectedTab.route
            ) {
                mainFlow(childNavController)
                measureFlow(childNavController)
                chatFlow(childNavController)
            }
        }

        if (!state.isBottomBarVisible) return

        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            NavigationBarView(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) { tab ->
                if (tab.route == state.selectedTab.route) return@NavigationBarView
                dispatch(Intent.OnTabClicked(tab))
                childNavController.navigate(tab.route) {
                    popUpTo(childNavController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }
}
