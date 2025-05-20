package com.javalenciab90.domain.repository

import kotlinx.coroutines.flow.Flow
import com.javalenciab90.domain.Result

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Result<Unit>>
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Result<Unit>>
    //suspend fun signInWithGoogle(idToken: String): Response<Nothing>
    //suspend fun getCurrentUser()
    suspend fun isLoggedIn(): Boolean
    suspend fun signOut(): Flow<Result<Unit>>
}