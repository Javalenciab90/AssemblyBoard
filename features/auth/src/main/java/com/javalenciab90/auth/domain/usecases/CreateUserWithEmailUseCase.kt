package com.javalenciab90.auth.domain.usecases

import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import com.javalenciab90.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateUserWithEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(email: String, password: String): Flow<Resource<Unit, AuthFirebaseException>> {
        return authRepository.createUserWithEmailAndPassword(email, password)
    }
}