package com.javalenciab90.assemblyboard.navigation

import android.content.Context
import android.content.Intent
import com.javalenciab90.assemblyboard.ui.MainActivity
import com.javalenciab90.deeplinks.domain.contracts.DeeplinkProcessor
import com.javalenciab90.deeplinks.routes.Deeplink
import javax.inject.Inject

class AuthenticationLinkProcessor @Inject constructor() : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink == Deeplink.Authentication.route
    }

    override fun execute(context: Context, deeplink: String): Boolean {
        context.startActivity(
            Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        )
        return true
    }
}