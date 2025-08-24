package com.javalenciab90.data.repository

import com.javalenciab90.data.mappers.mapToResourceFlow
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import com.javalenciab90.domain.models.UserProfile
import com.javalenciab90.domain.repositories.HomeRepository
import com.javalenciab90.service.AuthFirebaseService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val authFirebaseService: AuthFirebaseService
) : HomeRepository {

    override suspend fun getCurrentUser(): Flow<Resource<UserProfile, AuthFirebaseException>> {
        return authFirebaseService.getCurrentUser().mapToResourceFlow(
            dataMapper = {
                UserProfile(
                    uid = it.uid,
                    displayName = it.displayName ?: "",
                    email = it.email ?: "",
                    photoUrl = it.photoUrl?.toString(),
                    phoneNumber = it.phoneNumber
                )
            },
            errorMapper = { AuthFirebaseException.getError(it) }
        )
    }
}