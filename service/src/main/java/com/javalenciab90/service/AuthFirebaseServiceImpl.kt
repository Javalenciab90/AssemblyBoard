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

    override suspend fun isLoggedIn(): Flow<Response<Boolean>> = flow {
        try {
            emit(
                Response.Success(auth.currentUser != null)
            )
        } catch (authException: FirebaseAuthException) {
            emit(
                Response.Error(code = authException.errorCode)
            )
        } catch (exception: Exception) {
            emit(
                Response.Error(exception.localizedMessage)
            )
        }
    }

    override suspend fun getCurrentUser(): Flow<Response<String>> = flow {
        try {
            auth.currentUser?.let { user ->
                emit(
                    Response.Success(user.uid)
                )
            } ?: emit(Response.Error("User is null"))
        } catch (authException: FirebaseAuthException) {
            emit(
                Response.Error(code = authException.errorCode)
            )
        } catch (exception: Exception) {
            emit(
                Response.Error(exception.localizedMessage)
            )
        }
    }

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
            if (auth.currentUser == null) {
                emit(Response.Error("User is null"))
            } else {
                auth.signOut()
                emit(Response.Success(Unit))
            }
        } catch (authException: FirebaseAuthException) {
            emit(Response.Error(code = authException.errorCode))
        } catch (exception: Exception) {
            emit(Response.Error(exception.localizedMessage))
        }
    }

}