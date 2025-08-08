package com.javalenciab90.deeplinks.utils

import android.net.Uri


fun String.getQueryParams(): Map<String, String> {
    val uri = Uri.parse(this)
    return uri.query?.split("&")?.associate {
        val (key, value) = it.split("=")
        key to value
    } ?: emptyMap()
}

fun String.getPath(): String {
    val uri = Uri.parse(this)
    return uri.path.orEmpty()
}