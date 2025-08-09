package com.javalenciab90.auth.domain.usecases.validators

class PasswordNotBlankRule : ValidationRule<String> {

    override fun validate(value: String): ValidationResult {
        return if (value.isBlank()) {
            ValidationResult.Failure(CredentialsValidationError.PasswordInvalid)
        } else {
            ValidationResult.Success
        }
    }
}