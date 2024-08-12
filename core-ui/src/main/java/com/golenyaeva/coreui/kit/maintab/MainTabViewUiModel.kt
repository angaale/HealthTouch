package com.golenyaeva.coreui.kit.maintab

import androidx.annotation.StringRes
import com.golenyaeva.core_ui.R
import com.golenyaeva.coreui.kit.cardactivity.CardActivitiesModel
import com.golenyaeva.coreui.kit.measuringbpmhrv.MeasuringBpmHrvUiModel
import com.golenyaeva.coreui.kit.selffeeling.SelfFeelingUiModel

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

    data class CardsActivitiesTab(
        @StringRes override val titleRes: Int = R.string.main_tab_title_recent_activities,
        override val subtitle: String,
        @StringRes override val buttonTextRes: Int? = R.string.main_tab_button_recent_activities,
        val activitiesModel: List<CardActivitiesModel>,
    ) : MainTabViewUiModel(titleRes, subtitle, buttonTextRes)

    data class CardsRecommendationsTab(
        @StringRes override val titleRes: Int = R.string.main_tab_title_recommendation_activities,
        override val subtitle: String,
        @StringRes override val buttonTextRes: Int? = R.string.main_tab_button_self_feeling,
        val activitiesModel: List<CardActivitiesModel>,
    ) : MainTabViewUiModel(titleRes, subtitle, buttonTextRes)
}
