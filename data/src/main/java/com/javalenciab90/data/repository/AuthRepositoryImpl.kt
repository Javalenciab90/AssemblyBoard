package com.javalenciab90.data.repository

import com.javalenciab90.data.mappers.toResult
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.repositories.AuthRepository
import com.javalenciab90.service.AuthFirebaseService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authFirebaseService: AuthFirebaseService
): AuthRepository  {

    override suspend fun isLoggedIn(): Flow<Resource<Boolean>> {
        return authFirebaseService.isLoggedIn().map { it.toResult() }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit>> {
        return authFirebaseService.signInWithEmailAndPassword(email, password).map { it.toResult() }
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit>> {
        return authFirebaseService.createUserWithEmailAndPassword(email, password).map { it.toResult() }
    }

    override suspend fun signOut(): Flow<Resource<Unit>> {
        return authFirebaseService.signOut().map { it.toResult() }
    }
}