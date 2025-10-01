package com.javalenciab90.service.realtime

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.javalenciab90.service.models.Response
import com.javalenciab90.service.models.UserDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreServiceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : FirestoreService {

    override suspend fun createUserDocument(userDTO: UserDTO): Flow<Response<Unit, String>> = flow {
        try {
            if (isDocumentCreated(userDTO.uid)) {
                emit(Response.Success(Unit))
            } else {
                firestore
                    .collection("users")
                    .document(userDTO.uid)
                    .set(userDTO)
                    .await()
                    .let {
                        emit(Response.Success(Unit))
                    }
            }
        } catch (firestoreException: FirebaseFirestoreException) {
            emit(
                Response.Error(error = firestoreException.code.name)
            )
        } catch (exception: Exception) {
            emit(
                Response.Error(error = exception.localizedMessage ?: "UNKNOWN")
            )
        }
    }

    private suspend fun isDocumentCreated(uid: String): Boolean {
        firestore.collection("users") // TODO: Check the collection path
            .document(uid)
            .get()
            .await()
            .let { documentSnapshot ->
                return documentSnapshot.exists() && documentSnapshot.data != null
            }
    }
}