package com.javalenciab90.data.repository

import com.javalenciab90.data.mappers.RequestMapper
import com.javalenciab90.data.mappers.mapToResourceFlow
import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import com.javalenciab90.domain.models.FirestoreException
import com.javalenciab90.domain.models.UserProfile
import com.javalenciab90.domain.repositories.HomeRepository
import com.javalenciab90.service.authentication.AuthFirebaseService
import com.javalenciab90.service.models.UserDTO
import com.javalenciab90.service.realtime.FirestoreService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val authFirebaseService: AuthFirebaseService,
    private val firestoreService: FirestoreService,
    private val userRequestMapper: RequestMapper<UserProfile, UserDTO>
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

    override suspend fun createUserDocument(user: UserProfile): Flow<Resource<Unit, FirestoreException>> {
        val userDTO = userRequestMapper.mapToRequest(user)
        return firestoreService.createUserDocument(userDTO).mapToResourceFlow(
            dataMapper = { },
            errorMapper = { FirestoreException.getError(it) }
        )
    }
}