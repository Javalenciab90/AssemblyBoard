package com.javalenciab90.auth.domain.usecases

import com.javalenciab90.domain.Result
import com.javalenciab90.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateUserWithEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(email: String, password: String): Flow<Result<Unit>> {
        return authRepository.createUserWithEmailAndPassword(email, password)
    }
}