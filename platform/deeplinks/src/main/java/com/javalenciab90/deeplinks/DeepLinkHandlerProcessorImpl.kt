package com.javalenciab90.deeplinks

import android.content.Context
import com.javalenciab90.deeplinks.domain.contracts.DeeplinkHandler
import com.javalenciab90.deeplinks.domain.contracts.DeeplinkProcessor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeepLinkHandlerProcessorImpl @Inject constructor(
    private val processors: Set<@JvmSuppressWildcards DeeplinkProcessor>
): DeeplinkHandler {

    override fun process(
        context: Context,
        deeplink: String
    ): Boolean {
        processors.forEach {
            if (it.matches(deeplink)) return it.execute(context, deeplink)
        }
        return false
    }
}