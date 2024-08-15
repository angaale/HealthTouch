package com.golenyaeva.healthtouch.data.local.localsource

import com.golenyaeva.healthtouch.data.local.dao.UserDao
import com.golenyaeva.healthtouch.domain.UserModel
import com.golenyaeva.healthtouch.domain.repository.UserLocalSource
import javax.inject.Inject

class UserLocalSourceImpl @Inject constructor(
    private val userDao: UserDao,
) : UserLocalSource {
    override suspend fun getUser(): UserModel? {
        val user = userDao.get() ?: return null
        return UserModel(
            image = user.image,
            firstName = user.firstName,
            lastName = user.lastName,
            height = user.height,
            weight = user.weight,
        )
    }
}
