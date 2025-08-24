package com.javalenciab90.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthFirebaseServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthFirebaseService {

    override suspend fun isLoggedIn(): Flow<Response<Boolean, String>> = flow {
        try {
            emit(
                Response.Success(auth.currentUser != null)
            )
        } catch (authException: FirebaseAuthException) {
            emit(
                Response.Error(error = authException.errorCode)
            )
        } catch (exception: Exception) {
            emit(
                Response.Error(error = exception.localizedMessage ?: "UNKNOWN")
            )
        }
    }

    override suspend fun getCurrentUser(): Flow<Response<FirebaseUser, String>> = flow {
        try {
            auth.currentUser?.let { user ->
                emit(
                    Response.Success(user)
                )
            } ?: emit(Response.Error("User is null"))
        } catch (authException: FirebaseAuthException) {
            emit(
                Response.Error(error = authException.errorCode)
            )
        } catch (exception: Exception) {
            emit(
                Response.Error(error = exception.localizedMessage ?: "UNKNOWN")
            )
        }
    }

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): Flow<Response<Unit, String>> = flow {
        try {
            val data = auth.createUserWithEmailAndPassword(email, password).await()
            if (data.user != null) {
                emit(Response.Success(Unit))
            } else {
                emit(Response.Error("UNCREATED_USER"))
            }
        } catch (authException: FirebaseAuthException){
            emit(Response.Error(error = authException.errorCode))
        } catch (exception: Exception) {
            emit(Response.Error(error = exception.localizedMessage ?: "UNKNOWN"))
        }
    }

    override suspend fun signInWithGoogle(idToken: String): Flow<Response<Unit, String>> = flow {
        try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val authResult = auth.signInWithCredential(credential).await()
            val user = authResult.user
            if (user != null) {
                emit(Response.Success(Unit))
            } else {
                emit(Response.Error(error = "UNCREATED_USER"))
            }
        } catch (authException: FirebaseAuthException){
            emit(Response.Error(error = authException.errorCode))
        } catch (exception: Exception) {
            emit(Response.Error(error = exception.localizedMessage ?: "UNKNOWN"))
        }
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<Response<Unit, String>> = flow {
        try {
            val data = auth.signInWithEmailAndPassword(email, password).await()
            if (data.user != null) {
                emit(Response.Success(Unit))
            } else {
                emit(Response.Error("UNCREATED_USER"))
            }
        } catch (authException: FirebaseAuthException) {
            emit(Response.Error(error = authException.errorCode))
        } catch (exception: Exception) {
            emit(Response.Error(error = exception.localizedMessage ?: "UNKNOWN"))
        }
    }

    override suspend fun signOut(): Flow<Response<Unit, String>> = flow {
        try {
            if (auth.currentUser == null) {
                emit(Response.Error("UNCREATED_USER"))
            } else {
                auth.signOut()
                emit(Response.Success(Unit))
            }
        } catch (authException: FirebaseAuthException) {
            emit(Response.Error(error = authException.errorCode))
        } catch (exception: Exception) {
            emit(Response.Error(error = exception.localizedMessage ?: "UNKNOWN"))
        }
    }

}