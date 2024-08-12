package com.golenyaeva.coreui.kit.selffeeling

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.golenyaeva.core_ui.R
import com.golenyaeva.coreui.theme.LightGreen
import com.golenyaeva.coreui.theme.LightPink
import com.golenyaeva.coreui.theme.LightYellow

sealed class SelfFeelingUiModel(
    @StringRes open val title: Int,
    @StringRes open val subtitle: Int,
    open val percent: Int,
    open val backgroundColor: Color,
) {
    data class Bad(
        @StringRes override val title: Int = R.string.self_feeling_title_bad,
        @StringRes override val subtitle: Int = R.string.self_feeling_subtitle_bad,
        override val percent: Int,
        override val backgroundColor: Color = LightPink,
    ) : SelfFeelingUiModel(title, subtitle, percent, backgroundColor)

    data class Okay(
        @StringRes override val title: Int = R.string.self_feeling_title_okay,
        @StringRes override val subtitle: Int = R.string.self_feeling_subtitle_okay,
        override val percent: Int,
        override val backgroundColor: Color = LightYellow,
    ) : SelfFeelingUiModel(title, subtitle, percent, backgroundColor)

    data class Good(
        @StringRes override val title: Int = R.string.self_feeling_title_good,
        @StringRes override val subtitle: Int = R.string.self_feeling_subtitle_good,
        override val percent: Int,
        override val backgroundColor: Color = LightGreen,
    ) : SelfFeelingUiModel(title, subtitle, percent, backgroundColor)
}
