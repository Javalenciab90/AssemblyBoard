package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import com.javalenciab90.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(): Flow<Resource<Boolean, AuthFirebaseException>> {
        return authRepository.isLoggedIn()
    }
}