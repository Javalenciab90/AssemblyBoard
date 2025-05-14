package com.javalenciab90.data.repository

import com.javalenciab90.service.Response
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Nothing>>
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Response<Nothing>>
    //suspend fun signInWithGoogle(idToken: String): Response<Nothing>
    //suspend fun getCurrentUser()
    suspend fun signOut(): Flow<Response<Unit>>
}