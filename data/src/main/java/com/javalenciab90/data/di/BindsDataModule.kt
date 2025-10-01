package com.javalenciab90.data.di

import com.javalenciab90.data.mappers.RequestMapper
import com.javalenciab90.data.mappers.implementations.UserRequestMapperImpl
import com.javalenciab90.data.repository.AuthRepositoryImpl
import com.javalenciab90.data.repository.HomeRepositoryImpl
import com.javalenciab90.domain.models.UserProfile
import com.javalenciab90.domain.repositories.AuthRepository
import com.javalenciab90.domain.repositories.HomeRepository
import com.javalenciab90.service.models.UserDTO
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsDataModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl) : AuthRepository

    @Binds
    @Singleton
    abstract fun bindHomeRepository(impl: HomeRepositoryImpl) : HomeRepository

    @Binds
    @Singleton
    abstract fun bindRequestMapper(impl: UserRequestMapperImpl) : RequestMapper<UserProfile, UserDTO>

}