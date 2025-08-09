package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke() : Flow<Resource<Unit>> {
        return authRepository.signOut()
    }

}