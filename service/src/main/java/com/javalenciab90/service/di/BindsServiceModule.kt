package com.javalenciab90.service.di

import com.javalenciab90.service.authentication.AuthFirebaseService
import com.javalenciab90.service.authentication.AuthFirebaseServiceImpl
import com.javalenciab90.service.realtime.FirestoreService
import com.javalenciab90.service.realtime.FirestoreServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsServiceModule {

    @Binds
    abstract fun bindFirebaseAuthService(
        impl: AuthFirebaseServiceImpl
    ) : AuthFirebaseService

    @Binds
    abstract fun bindFirestoreService(
        impl: FirestoreServiceImpl
    ) : FirestoreService
}