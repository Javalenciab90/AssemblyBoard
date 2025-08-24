package com.javalenciab90.domain.repositories

import kotlinx.coroutines.flow.Flow
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import com.javalenciab90.domain.models.UserProfile

interface AuthRepository {
    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit, AuthFirebaseException>>
    suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit, AuthFirebaseException>>
    suspend fun signInWithGoogle(idToken: String): Flow<Resource<Unit, AuthFirebaseException>>
    suspend fun isLoggedIn(): Flow<Resource<Boolean, AuthFirebaseException>>
    suspend fun signOut(): Flow<Resource<Unit, AuthFirebaseException>>
}