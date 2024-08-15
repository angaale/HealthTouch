package com.golenyaeva.healthtouch.presentation.screen.main.model

data class MainScreenUiModel(
    val selectedTab: MainTabRoute,
) {
    val isBottomBarVisible: Boolean
        get() = selectedTab != MainTabRoute.Measure
}
