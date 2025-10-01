package com.javalenciab90.home.domain.usecases

import com.javalenciab90.domain.Resource
import com.javalenciab90.domain.models.FirestoreException
import com.javalenciab90.domain.models.UserProfile
import com.javalenciab90.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateUserDocumentUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(user: UserProfile): Flow<Resource<Unit, FirestoreException>> {
        return homeRepository.createUserDocument(user)
    }
}