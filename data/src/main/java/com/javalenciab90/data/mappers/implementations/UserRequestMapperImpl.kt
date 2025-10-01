package com.javalenciab90.data.mappers.implementations

import com.javalenciab90.data.mappers.RequestMapper
import com.javalenciab90.domain.models.UserProfile
import com.javalenciab90.service.models.UserDTO
import javax.inject.Inject

class UserRequestMapperImpl @Inject constructor() : RequestMapper<UserProfile, UserDTO> {

    override fun mapToRequest(domain: UserProfile): UserDTO {
        return UserDTO(
            uid = domain.uid,
            displayName = domain.displayName,
            email = domain.email,
            photoUrl = domain.photoUrl,
            phoneNumber = domain.phoneNumber
        )
    }
}