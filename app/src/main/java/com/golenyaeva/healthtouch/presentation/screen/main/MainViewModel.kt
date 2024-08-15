package com.golenyaeva.healthtouch.presentation.screen.main

import com.golenyaeva.base.BaseViewModel
import com.golenyaeva.healthtouch.presentation.screen.main.model.Intent
import com.golenyaeva.healthtouch.presentation.screen.main.model.MainTabRoute
import com.golenyaeva.healthtouch.presentation.screen.main.model.MainScreenUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<Intent>() {

    private val _uiState = MutableStateFlow(MainScreenUiModel(STARTED_TAB))
    val uiState: StateFlow<MainScreenUiModel> = _uiState.asStateFlow()

    override fun handleIntent(intent: Intent) = when (intent) {
        is Intent.OnTabClicked -> _uiState.value = uiState.value.copy(selectedTab = intent.tab)
    }

    private companion object {
        private val STARTED_TAB = MainTabRoute.Home
    }
}
