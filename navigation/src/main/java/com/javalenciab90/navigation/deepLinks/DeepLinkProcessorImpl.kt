package com.javalenciab90.navigation.deepLinks

import javax.inject.Inject

class DeepLinkProcessorImpl @Inject constructor(
    private val processors: Set<@JvmSuppressWildcards DeeplinkProcessor>
): DeeplinkHandler {

    override fun process(deeplink: String): Boolean {
        TODO("Not yet implemented")
    }
}