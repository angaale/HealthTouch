package com.golenyaeva.healthtouch.presentation.screen.home.model

import com.golenyaeva.coreui.kit.maintab.MainTabViewUiModel
import com.golenyaeva.healthtouch.domain.UserModel

data class HomeUiModel(
    val user: UserModel,
    val tabs: List<MainTabViewUiModel> = listOf(),
)
