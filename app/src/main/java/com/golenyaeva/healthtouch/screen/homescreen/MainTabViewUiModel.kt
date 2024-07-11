package com.golenyaeva.healthtouch.screen.homescreen

import androidx.annotation.StringRes

sealed class MainTabViewUiModel(
    @StringRes open val titleRes: Int,
    open val subtitle: String,
    @StringRes open val buttonTextRes: Int? = null,
) {
    data class Measuring(
        override val titleRes: Int,
        override val subtitle: String,
        override val buttonTextRes: Int? = null,
        val measuring: MeasuringBpmHrvUiModel,
    ) : MainTabViewUiModel(titleRes, subtitle, buttonTextRes)
}
