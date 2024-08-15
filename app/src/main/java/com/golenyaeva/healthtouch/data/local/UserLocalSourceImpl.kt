package com.golenyaeva.healthtouch.data.local

import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.domain.repository.UserLocalSource
import javax.inject.Inject

class UserLocalSourceImpl @Inject constructor() : UserLocalSource {
    override suspend fun getUser() = UserModel(
        firstName = "Евгений",
        lastName = "Онегин",
        image = "image",
        height = 100,
        weight = 100,
    )
}
