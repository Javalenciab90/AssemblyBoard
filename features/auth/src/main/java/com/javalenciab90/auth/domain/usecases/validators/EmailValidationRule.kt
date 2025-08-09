package com.javalenciab90.auth.domain.usecases.validators

import com.javalenciab90.auth.utils.isEmailNoValid

/**
 *  Represents the result of a validation rule implementation,
 *  that validates a value of type T, in this case the email string
 */

class EmailValidationRule : ValidationRule<String> {

    override fun validate(value: String): ValidationResult {
        return if (value.isEmailNoValid()) {
            ValidationResult.Failure(CredentialsValidationError.EmailInvalid)
        } else ValidationResult.Success
    }
}