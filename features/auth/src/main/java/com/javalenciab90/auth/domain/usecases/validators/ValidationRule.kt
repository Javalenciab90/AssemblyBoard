package com.javalenciab90.auth.domain.usecases.validators

/**
 * Represents a validation rule that validates a value of type T.
 */

interface ValidationRule<T> {
    fun validate(value: T): ValidationResult
}
