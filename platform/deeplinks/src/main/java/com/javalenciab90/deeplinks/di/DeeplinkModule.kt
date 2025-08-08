package com.javalenciab90.deeplinks.di

import com.javalenciab90.deeplinks.DeepLinkHandlerProcessorImpl
import com.javalenciab90.deeplinks.domain.contracts.DeeplinkHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DeeplinkModule {

    @Binds
    abstract fun bindDeeplinkHandler(impl: DeepLinkHandlerProcessorImpl): DeeplinkHandler
}