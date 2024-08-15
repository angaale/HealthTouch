package com.golenyaeva.healthtouch.di

import com.golenyaeva.healthtouch.data.local.localsource.UserLocalSourceImpl
import com.golenyaeva.healthtouch.domain.repository.UserLocalSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressWarnings("TooManyFunctions")
@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryDiModule {

    @Binds
    @Singleton
    fun bindUserLocalSource(source: UserLocalSourceImpl): UserLocalSource
}
