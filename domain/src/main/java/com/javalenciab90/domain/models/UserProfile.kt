package com.javalenciab90.domain.models

data class UserProfile(
    val uid: String,
    val displayName: String,
    val email: String,
    val photoUrl: String? = null,
    val phoneNumber: String? = null
)