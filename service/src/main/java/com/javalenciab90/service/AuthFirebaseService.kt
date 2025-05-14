package com.javalenciab90.service

import kotlinx.coroutines.flow.Flow

interface AuthFirebaseService {
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Response<Unit>>
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Unit>>
//    suspend fun signInWithGoogle(idToken: String): Response<Unit>
//    suspend fun getCurrentUser(): Unit?
    suspend fun signOut(): Flow<Response<Unit>>
}