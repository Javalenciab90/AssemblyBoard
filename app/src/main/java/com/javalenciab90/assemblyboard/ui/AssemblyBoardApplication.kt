package com.javalenciab90.assemblyboard.ui

import android.app.Application
import com.javalenciab90.assemblyboard.navigator.DeeplinkHandlerEntryPoint
import com.javalenciab90.base.providers.AppProvider
import com.javalenciab90.deeplinks.domain.contracts.DeeplinkHandler
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.HiltAndroidApp


/**
 * This is manual Hilt dependency access using an @EntryPoint.
 * Let’s walk through it:
 *
 * 👉 EntryPointAccessors.fromApplication(...)
 * Tells Hilt: “Give me access to a manually defined @EntryPoint starting from this Application context.”
 * 👉 DeeplinkHandlerEntryPoint::class.java
 * This is the interface that tells Hilt which dependencies you want to access manually.
 */

@HiltAndroidApp
class AssemblyBoardApplication : Application(), AppProvider {

    override val deeplinkHandler: DeeplinkHandler
        get() = EntryPointAccessors
            .fromApplication(this, DeeplinkHandlerEntryPoint::class.java)
            .deeplinkHandler()

}