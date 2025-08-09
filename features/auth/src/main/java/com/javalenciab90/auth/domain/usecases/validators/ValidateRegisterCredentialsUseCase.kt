package com.javalenciab90.auth.domain.usecases.validators

import com.javalenciab90.auth.domain.models.UserCredentialsModel
import com.javalenciab90.auth.utils.isEmailNoValid
import javax.inject.Inject

class ValidateRegisterCredentialsUseCase @Inject constructor() {

    operator fun invoke(credentials: UserCredentialsModel): ValidationResult {
        return when {
            credentials.email.isEmailNoValid() ->
                ValidationResult.Failure(CredentialsValidationError.EmailInvalid)

            credentials.password.isBlank() || credentials.confirmPassword.isNullOrBlank() ->
                ValidationResult.Failure(CredentialsValidationError.PasswordInvalid)

            credentials.password != credentials.confirmPassword ->
                ValidationResult.Failure(CredentialsValidationError.PasswordsDoNotMatch)

            else -> ValidationResult.Success
        }
    }
}
