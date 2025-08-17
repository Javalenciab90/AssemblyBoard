package com.javalenciab90.assemblyboard.navigation

import com.javalenciab90.deeplinks.domain.contracts.DeeplinkHandler
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * This provides the actual implementation of AppProvider,
 * so any module that has Context can access it.
 * 👉 .deeplinkHandler()
 * This actually retrieves the instance of DeeplinkHandler that Hilt manages under the hood.
 */

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DeeplinkHandlerEntryPoint {
    fun deeplinkHandler(): DeeplinkHandler
}
