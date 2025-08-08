package com.javalenciab90.home.navigation.deeplinks

import android.content.Context
import android.content.Intent
import com.javalenciab90.home.HomeActivity
import com.javalenciab90.deeplinks.domain.contracts.DeeplinkProcessor
import com.javalenciab90.deeplinks.routes.Deeplink
import javax.inject.Inject

class HomeDeeplinkProcessor @Inject constructor() : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink == Deeplink.Home.route
    }

    override fun execute(
        context: Context,
        deeplink: String
    ) : Boolean {
        context.startActivity(Intent(context, HomeActivity::class.java))
        return true
    }
}
