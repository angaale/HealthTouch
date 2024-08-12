package com.golenyaeva.healthtouch.presentation.screen.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingUIModel(
    @DrawableRes val imageRes: Int? = null,
    @StringRes val title: Int? = null,
    @StringRes val description: Int? = null,
    val currentPage: Int = 1,
)
