package com.golenyaeva.healthtouch.screen.home

import com.golenyaeva.healthtouch.domain.UserModel

data class HomeUiModel(
    val user: UserModel,
    val tabs: List<MainTabViewUiModel> = listOf(),
)
