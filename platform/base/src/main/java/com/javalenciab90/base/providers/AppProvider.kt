package com.javalenciab90.base.providers

import com.javalenciab90.deeplinks.domain.contracts.DeeplinkHandler

/**
 *  Works as service locator for the app.
 *  Can be set for example a Logger - ImageLoader - etc.
 */

interface AppProvider {
    val deeplinkHandler: DeeplinkHandler
}