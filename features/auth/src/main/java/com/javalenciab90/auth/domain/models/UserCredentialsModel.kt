package com.javalenciab90.auth.domain.models

data class UserCredentialsModel(
    val email: String,
    val password: String,
    val confirmPassword: String? = null
)
