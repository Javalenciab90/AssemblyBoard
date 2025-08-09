package com.javalenciab90.auth.domain.usecases.validators

import com.javalenciab90.auth.domain.models.UserCredentialsModel
import com.javalenciab90.auth.utils.isEmailNoValid
import javax.inject.Inject

class ValidateLoginCredentialsUseCase @Inject constructor() {

    operator fun invoke(credentials: UserCredentialsModel): ValidationResult {
        return when {
            credentials.email.isEmailNoValid() ->
                ValidationResult.Failure(CredentialsValidationError.EmailInvalid)

            credentials.password.isBlank() ->
                ValidationResult.Failure(CredentialsValidationError.PasswordInvalid)

            else -> ValidationResult.Success
        }
    }
}
