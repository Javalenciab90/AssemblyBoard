package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.repository.AuthRepository
import javax.inject.Inject

class IsLoggedInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(): Boolean = authRepository.isLoggedIn()
}