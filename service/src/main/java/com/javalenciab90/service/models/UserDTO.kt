package com.javalenciab90.service.models

data class UserDTO(
    val uid: String,
    val displayName: String,
    val email: String,
    val photoUrl: String? = null,
    val phoneNumber: String? = null
)
