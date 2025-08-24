package com.javalenciab90.domain.usecases

import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.AuthFirebaseException
import com.javalenciab90.domain.models.UserProfile
import com.javalenciab90.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke() : Flow<Resource<UserProfile, AuthFirebaseException>> {
        return homeRepository.getCurrentUser()
    }
}