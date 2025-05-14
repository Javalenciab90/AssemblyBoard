package com.javalenciab90.data.repository

import com.javalenciab90.service.Response

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): Response<Nothing>
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Response<Nothing>
    suspend fun signInWithGoogle(idToken: String): Response<Nothing>
    suspend fun getCurrentUser()
    suspend fun signOut(): Response<Unit>
}