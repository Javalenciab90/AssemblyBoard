package com.javalenciab90.data.repository

import com.javalenciab90.data.mappers.toResourceFlow
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import com.javalenciab90.domain.repositories.HomeRepository
import com.javalenciab90.service.AuthFirebaseService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val authFirebaseService: AuthFirebaseService
) : HomeRepository {

    override suspend fun getCurrentUser(): Flow<Resource<String, AuthFirebaseException>> {
        return authFirebaseService.getCurrentUser().toResourceFlow { AuthFirebaseException.getError(it) }
    }

}