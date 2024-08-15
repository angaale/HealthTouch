package com.golenyaeva.healthtouch.presentation.screen.home

import com.golenyaeva.healthtouch.base.BaseViewModel
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeUiModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.Intent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<Intent>() {

    private val _uiState = MutableStateFlow(getInitState())
    val uiState: StateFlow<HomeUiModel> = _uiState.asStateFlow()

    override fun handleIntent(intent: Intent) {
        TODO("Not yet implemented")
    }

    private fun getInitState() = HomeUiModel(
        user = UserModel(
            image = "",
            firstName = "",
            lastName = "",
            height = 0,
            weight = 0,
        )
    )
}
