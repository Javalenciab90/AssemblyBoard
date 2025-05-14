package com.javalenciab90.data.repository

import com.javalenciab90.service.AuthFirebaseService
import com.javalenciab90.service.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authFirebaseService: AuthFirebaseService
): AuthRepository {

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Nothing>> = flow {
        authFirebaseService.signInWithEmailAndPassword(email, password)
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Response<Nothing>> = flow {
        authFirebaseService.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun signOut(): Flow<Response<Unit>> = flow {
        authFirebaseService.signOut()
    }
}