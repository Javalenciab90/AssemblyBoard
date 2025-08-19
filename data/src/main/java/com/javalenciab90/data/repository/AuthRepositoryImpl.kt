package com.javalenciab90.data.repository

import com.javalenciab90.data.mappers.toResourceFlow
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import com.javalenciab90.domain.repositories.AuthRepository
import com.javalenciab90.service.AuthFirebaseService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authFirebaseService: AuthFirebaseService
): AuthRepository  {

    override suspend fun isLoggedIn(): Flow<Resource<Boolean, AuthFirebaseException>> {
        return authFirebaseService.isLoggedIn().toResourceFlow { AuthFirebaseException.getError(it) }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit, AuthFirebaseException>> {
        return authFirebaseService.signInWithEmailAndPassword(email, password).toResourceFlow { AuthFirebaseException.getError(it) }
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Resource<Unit, AuthFirebaseException>> {
        return authFirebaseService.createUserWithEmailAndPassword(email, password).toResourceFlow { AuthFirebaseException.getError(it) }
    }

    override suspend fun signOut(): Flow<Resource<Unit, AuthFirebaseException>> {
        return authFirebaseService.signOut().toResourceFlow { AuthFirebaseException.getError(it) }
    }
}