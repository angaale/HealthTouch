package com.golenyaeva.healthtouch.ui.kit.button

import androidx.annotation.StringRes

data class ButtonViewUiModel(
    @StringRes val textButtonRes: Int,
    val style: Style = Style.PRIMARY,
    val isLoading: Boolean = false,
    val enabled: Boolean = true,
) {
    enum class Style {
        PRIMARY, SECONDARY
    }
}
