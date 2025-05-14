package com.javalenciab90.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthFirebaseServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthFirebaseService {

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Response<Unit>> = flow {
        try {
            val data = auth.createUserWithEmailAndPassword(email, password).await()
            if (data.user != null) {
                emit(Response.Success(Unit))
            } else {
                emit(Response.Error("User was not created"))
            }
        } catch (authException: FirebaseAuthException){
            emit(Response.Error(code = authException.errorCode))
        } catch (exception: Exception) {
            emit(Response.Error(exception.localizedMessage))
        }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Unit>> = flow {
        try {
            val data = auth.signInWithEmailAndPassword(email, password).await()
            if (data.user != null) {
                emit(Response.Success(Unit))
            } else {
                emit(Response.Error("User was not created"))
            }
        } catch (authException: FirebaseAuthException) {
            emit(Response.Error(code = authException.errorCode))
        } catch (exception: Exception) {
            emit(Response.Error(exception.localizedMessage))
        }
    }

    override suspend fun signOut(): Flow<Response<Unit>> = flow {
        try {
            auth.signOut()
            emit(Response.Success(Unit))
        } catch (authException: FirebaseAuthException) {
            emit(Response.Error(code = authException.errorCode))
        } catch (exception: Exception) {
            emit(Response.Error(exception.localizedMessage))
        }
    }

}