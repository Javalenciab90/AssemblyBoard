package com.javalenciab90.domain.repositories

import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getCurrentUser() : Flow<Resource<String, AuthFirebaseException>>
}