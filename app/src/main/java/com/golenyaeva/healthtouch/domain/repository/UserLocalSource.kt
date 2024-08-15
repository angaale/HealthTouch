package com.golenyaeva.healthtouch.domain.repository

import com.golenyaeva.healthtouch.domain.UserModel

interface UserLocalSource {
    suspend fun getUser(): UserModel?
}
