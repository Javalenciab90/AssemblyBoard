package com.javalenciab90.domain.repositories

import com.javalenciab90.domain.Resource
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getCurrentUser() : Flow<Resource<String>>
}