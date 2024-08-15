package com.golenyaeva.healthtouch.presentation.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.presentation.EventHandler
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeEvent
import com.golenyaeva.healthtouch.presentation.screen.home.model.HomeUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : ViewModel(), EventHandler<HomeEvent> {

    private val _homeViewState: MutableLiveData<HomeUiModel> =
        MutableLiveData(HomeUiModel.NoItems(UserModel()))
    val homeViewState: LiveData<HomeUiModel> = _homeViewState

    override fun obtainEvent(event: HomeEvent) {
        TODO("Not yet implemented")
    }
}
