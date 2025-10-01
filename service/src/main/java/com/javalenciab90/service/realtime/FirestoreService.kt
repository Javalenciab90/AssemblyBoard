package com.javalenciab90.service.realtime

import com.javalenciab90.service.models.Response
import com.javalenciab90.service.models.UserDTO
import kotlinx.coroutines.flow.Flow

interface FirestoreService {
    suspend fun createUserDocument(userDTO: UserDTO): Flow<Response<Unit, String>>
}