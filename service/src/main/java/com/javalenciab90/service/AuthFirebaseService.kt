package com.javalenciab90.service

import kotlinx.coroutines.flow.Flow

interface AuthFirebaseService {
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Response<Unit, String>>
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Unit, String>>
//    suspend fun signInWithGoogle(idToken: String): Response<Unit>
    suspend fun getCurrentUser(): Flow<Response<String, String>>
    suspend fun isLoggedIn(): Flow<Response<Boolean, String>>
    suspend fun signOut(): Flow<Response<Unit, String>>
}