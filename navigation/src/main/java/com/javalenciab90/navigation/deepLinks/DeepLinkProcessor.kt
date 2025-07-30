package com.javalenciab90.navigation.deepLinks

/**
 * It will have two functions,
 * one to match the deeplink and the other one
 * to execute the launching of activity after matching.
 */

interface DeeplinkProcessor {
    fun matches(deeplink: String): Boolean

    fun execute(deeplink: String)
}