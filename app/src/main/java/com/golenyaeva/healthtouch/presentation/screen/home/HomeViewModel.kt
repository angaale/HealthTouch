package com.golenyaeva.healthtouch.presentation.screen.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComposeViewModel @Inject constructor(
) : ViewModel(), EventHandler<ComposeEvent> {

}
