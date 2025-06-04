package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.Result
import com.javalenciab90.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(): Flow<Result<Boolean>> {
        return authRepository.isLoggedIn()
    }
}