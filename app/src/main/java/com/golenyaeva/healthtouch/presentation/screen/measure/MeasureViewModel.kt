package com.golenyaeva.healthtouch.presentation.screen.measure

import com.golenyaeva.base.BaseViewModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.Intent
import com.golenyaeva.healthtouch.presentation.screen.measure.model.MeasureScreenUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MeasureViewModel @Inject constructor() : BaseViewModel<Intent>() {

    private val _uiState = MutableStateFlow(getInitState())
    val uiState: StateFlow<MeasureScreenUiModel> = _uiState.asStateFlow()

    override fun handleIntent(intent: Intent) {
        TODO("Not yet implemented")
    }

    private fun getInitState() = MeasureScreenUiModel(
        pulse = 60,
        progress = 50.0,
    )
}
