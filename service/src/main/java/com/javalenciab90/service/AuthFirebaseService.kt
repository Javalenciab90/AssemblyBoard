package com.javalenciab90.service

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthFirebaseService {
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Response<Unit, String>>
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Unit, String>>
    suspend fun signInWithGoogle(idToken: String): Flow<Response<Unit, String>>
    suspend fun getCurrentUser(): Flow<Response<FirebaseUser, String>>
    suspend fun isLoggedIn(): Flow<Response<Boolean, String>>
    suspend fun signOut(): Flow<Response<Unit, String>>
}