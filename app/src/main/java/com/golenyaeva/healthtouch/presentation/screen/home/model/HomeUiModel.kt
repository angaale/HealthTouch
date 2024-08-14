package com.golenyaeva.healthtouch.presentation.screen.home.model

import com.golenyaeva.coreui.kit.maintab.MainTabViewUiModel
import com.golenyaeva.healthtouch.domain.UserModel

sealed class HomeUiModel(open val user: UserModel) {
    data class Loading(override val user: UserModel = UserModel()) : HomeUiModel(user)
    data class Error(override val user: UserModel) : HomeUiModel(user)
    data class NoItems(override val user: UserModel) : HomeUiModel(user)
    data class Display(
        override val user: UserModel,
        val tabs: List<MainTabViewUiModel> = listOf(),
    ) : HomeUiModel(user)
}
