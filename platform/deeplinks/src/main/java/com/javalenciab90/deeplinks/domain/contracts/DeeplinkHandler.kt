package com.javalenciab90.deeplinks.domain.contracts

import android.content.Context

/**
 * function: called process whose responsibility
 * would be to execute the processor.
 */

interface DeeplinkHandler {
    fun process(
        context: Context,
        deeplink: String
    ): Boolean
}