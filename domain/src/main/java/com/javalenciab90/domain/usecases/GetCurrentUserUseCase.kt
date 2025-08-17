package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.repositories.HomeRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke() = homeRepository.getCurrentUser()
}