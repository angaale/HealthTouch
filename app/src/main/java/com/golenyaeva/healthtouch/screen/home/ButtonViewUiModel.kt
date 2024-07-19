package com.golenyaeva.healthtouch.screen.home

import androidx.annotation.StringRes

data class ButtonViewUiModel(
    @StringRes val textButtonRes: Int,
    val style: Style,
    val isLoading: Boolean,
    val enabled: Boolean = true,
) {
    enum class Style {
        PRIMARY, SECONDARY
    }
}
