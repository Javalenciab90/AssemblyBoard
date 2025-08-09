package com.javalenciab90.auth.utils

fun String.isEmailNoValid(): Boolean {
    val emailRegex = Regex("^[A-Za-z](.*)([@])(.+)(\\.)(.+)")
    return this.isEmpty() || !emailRegex.matches(this)
}