package com.javalenciab90.home.di

import com.javalenciab90.home.navigation.deeplinks.HomeDeeplinkProcessor
import com.javalenciab90.deeplinks.domain.contracts.DeeplinkProcessor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeDeeplinkModule {

    @Binds
    @IntoSet
    abstract fun providesHomeDeeplinkProcessor(processor: HomeDeeplinkProcessor) : DeeplinkProcessor
}
