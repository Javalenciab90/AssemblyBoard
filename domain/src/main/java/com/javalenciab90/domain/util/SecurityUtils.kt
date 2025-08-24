package com.javalenciab90.domain.util

import java.security.SecureRandom

fun generateSecureRandomNonce(length: Int = 32): String {
    val charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvwxyz-._"
    val random = SecureRandom()
    return (1..length)
        .map { charset[random.nextInt(charset.length)] }
        .joinToString("")
}
