package com.javalenciab90.data.repository

import com.javalenciab90.data.mappers.toResult
import com.javalenciab90.domain.Result
import com.javalenciab90.domain.repository.AuthRepository
import com.javalenciab90.service.AuthFirebaseService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authFirebaseService: AuthFirebaseService
): AuthRepository  {

    override suspend fun isLoggedIn(): Flow<Result<Boolean>> {
        return authFirebaseService.isLoggedIn().map { it.toResult() }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Result<Unit>> {
        return authFirebaseService.signInWithEmailAndPassword(email, password).map { it.toResult() }
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Result<Unit>> {
        return authFirebaseService.createUserWithEmailAndPassword(email, password).map { it.toResult() }
    }

    override suspend fun signOut(): Flow<Result<Unit>> {
        return authFirebaseService.signOut().map { it.toResult() }
    }
}