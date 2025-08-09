package com.javalenciab90.auth.domain.usecases.validators

sealed class ValidationResult {
    data object Success : ValidationResult()
    data class Failure(val error: CredentialsValidationError) : ValidationResult()
}

sealed class CredentialsValidationError {
    data object EmailInvalid : CredentialsValidationError()
    data object PasswordInvalid : CredentialsValidationError()
    data object PasswordsDoNotMatch : CredentialsValidationError()
}
