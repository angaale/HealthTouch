package com.golenyaeva.healthtouch.presentation.screen.home

import androidx.lifecycle.viewModelScope
import com.golenyaeva.base.BaseViewModel
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.domain.repository.UserLocalSource
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeScreenUiModel
import com.golenyaeva.healthtouch.presentation.screen.home.model.Intent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userLocalSource: UserLocalSource,
) : BaseViewModel<Intent>() {

    private val _uiState = MutableStateFlow(getInitState())
    val uiState: StateFlow<HomeScreenUiModel> = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userLocalSource.getUser()?.let { user ->
                _uiState.value = HomeScreenUiModel(user = user)
            }
        }
    }

    override fun handleIntent(intent: Intent) {
        TODO("Not yet implemented")
    }

    private fun getInitState() = HomeScreenUiModel(
        user = UserModel(
            image = "",
            firstName = "",
            lastName = "",
            height = 0,
            weight = 0,
        )
    )
}
