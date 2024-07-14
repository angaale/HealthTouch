package com.golenyaeva.healthtouch.screen.homescreen

import androidx.annotation.StringRes
import com.golenyaeva.healthtouch.R

sealed class MainTabViewUiModel(
    @StringRes open val titleRes: Int,
    open val subtitle: String,
    @StringRes open val buttonTextRes: Int? = null,
) {
    data class MeasuringTab(
        @StringRes override val titleRes: Int = R.string.main_tab_title_measure,
        override val subtitle: String,
        @StringRes override val buttonTextRes: Int? = R.string.main_tab_button_measure,
        val measuring: MeasuringBpmHrvUiModel,
    ) : MainTabViewUiModel(titleRes, subtitle, buttonTextRes)

    data class SelfFeelingTab(
        @StringRes override val titleRes: Int = R.string.main_tab_title_self_feeling,
        override val subtitle: String,
        @StringRes override val buttonTextRes: Int? = R.string.main_tab_button_self_feeling,
        val selfFeeling: SelfFeelingUiModel,
    ) : MainTabViewUiModel(titleRes, subtitle, buttonTextRes)
}
