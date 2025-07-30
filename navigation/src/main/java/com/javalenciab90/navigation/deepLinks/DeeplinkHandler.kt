package com.javalenciab90.navigation.deepLinks

/**
 * function: called process whose responsibility
 * would be to execute the processor.
 */

interface DeeplinkHandler {
    fun process(deeplink: String): Boolean
}