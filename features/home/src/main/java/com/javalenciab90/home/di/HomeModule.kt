package com.javalenciab90.home.di

import com.javalenciab90.domain.repositories.AuthRepository
import com.javalenciab90.domain.usecases.SignOutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HomeUseCaseModule {

    @Provides
    fun provideSignOutUseCase(repository: AuthRepository): SignOutUseCase {
        return SignOutUseCase(repository)
    }
}
