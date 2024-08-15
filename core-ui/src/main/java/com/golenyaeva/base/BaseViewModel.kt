package com.golenyaeva.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {
    abstract fun handleIntent(intent: T)
}
