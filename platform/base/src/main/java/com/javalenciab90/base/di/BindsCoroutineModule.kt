package com.javalenciab90.base.di

import com.javalenciab90.base.CoroutineContextProvider
import com.javalenciab90.base.DefaultCoroutineContextProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CoroutineModule {

    @Binds
    abstract fun bindCoroutineContextProvider(
        defaultCoroutineContextProvider: DefaultCoroutineContextProvider
    ): CoroutineContextProvider
}