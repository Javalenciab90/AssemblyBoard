package com.javalenciab90.domain.repositories

import kotlinx.coroutines.flow.Flow
import com.javalenciab90.domain.Resource

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit>>
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit>>
    //suspend fun signInWithGoogle(idToken: String): Response<Nothing>
    suspend fun isLoggedIn(): Flow<Resource<Boolean>>
    suspend fun signOut(): Flow<Resource<Unit>>
}