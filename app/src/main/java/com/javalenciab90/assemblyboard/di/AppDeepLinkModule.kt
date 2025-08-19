package com.javalenciab90.assemblyboard.di

import com.javalenciab90.assemblyboard.navigation.AuthenticationLinkProcessor
import com.javalenciab90.deeplinks.domain.contracts.DeeplinkProcessor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class AppDeepLinkModule {

    @Binds
    @IntoSet
    abstract fun bindsAuthenticationLinkProcessor(
        processor: AuthenticationLinkProcessor
    ): DeeplinkProcessor

}