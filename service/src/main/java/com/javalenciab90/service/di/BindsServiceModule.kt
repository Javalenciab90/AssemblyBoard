package com.javalenciab90.service.di

import com.javalenciab90.service.AuthFirebaseService
import com.javalenciab90.service.AuthFirebaseServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsServiceModule {

    @Binds
    abstract fun bindFirebaseService(
        impl: AuthFirebaseServiceImpl
    ) : AuthFirebaseService
}