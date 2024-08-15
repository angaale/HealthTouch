package com.golenyaeva.healthtouch.presentation.screen.main.model

sealed class Intent {
    data class OnTabClicked(val tab: MainTabRoute) : Intent()
}
