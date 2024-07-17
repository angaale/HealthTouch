package com.golenyaeva.healthtouch.screen.homescreen

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.golenyaeva.healthtouch.R
import com.golenyaeva.healthtouch.ui.theme.LightGreen
import com.golenyaeva.healthtouch.ui.theme.LightPink
import com.golenyaeva.healthtouch.ui.theme.LightYellow

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
