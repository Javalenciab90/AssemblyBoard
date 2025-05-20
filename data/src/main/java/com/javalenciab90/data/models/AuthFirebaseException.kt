package com.javalenciab90.data.models

sealed class AuthFirebaseException {

    abstract val errorCode: String

    companion object {
        fun getError(errorCode: String): AuthFirebaseException {
            return when (errorCode) {
                EmailAlreadyInUse.errorCode -> EmailAlreadyInUse
                InvalidEmail.errorCode -> InvalidEmail
                WrongPassword.errorCode -> WrongPassword
                UserNotFound.errorCode -> UserNotFound
                UserDisabled.errorCode -> UserDisabled
                ManyRequests.errorCode -> ManyRequests
                OperationNotAllowed.errorCode -> OperationNotAllowed
                else -> Unknown(errorCode)
            }
        }
    }

    data object EmailAlreadyInUse : AuthFirebaseException() {
        override val errorCode: String
            get() = "ERROR_EMAIL_ALREADY_IN_USE"
    }

    data object InvalidEmail : AuthFirebaseException() {
        override val errorCode: String
            get() = "ERROR_INVALID_EMAIL"
    }

    data object WrongPassword : AuthFirebaseException() {
        override val errorCode: String
            get() = "ERROR_WRONG_PASSWORD"
    }

    data object UserNotFound : AuthFirebaseException() {
        override val errorCode: String
            get() = "ERROR_USER_NOT_FOUND"
    }

    data object UserDisabled : AuthFirebaseException() {
        override val errorCode: String
            get() = "ERROR_USER_DISABLED"
    }

    data object ManyRequests : AuthFirebaseException() {
        override val errorCode: String
            get() = "ERROR_TOO_MANY_REQUESTS"
    }

    data object OperationNotAllowed : AuthFirebaseException() {
        override val errorCode: String
            get() = "ERROR_OPERATION_NOT_ALLOWED"
    }

    data class Unknown(override val errorCode: String) : AuthFirebaseException()
}