package com.javalenciab90.data.models

sealed class FirestoreException {

    abstract val errorCode: String

    companion object {
        fun getError(code: String): FirestoreException {
            return when (code) {
                Aborted.errorCode -> Aborted
                AlreadyExists.errorCode -> AlreadyExists
                Cancelled.errorCode -> Cancelled
                DataLoss.errorCode -> DataLoss
                DeadlineExceeded.errorCode -> DeadlineExceeded
                FailedPrecondition.errorCode -> FailedPrecondition
                Internal.errorCode -> Internal
                InvalidArgument.errorCode -> InvalidArgument
                NotFound.errorCode -> NotFound
                OutOfRange.errorCode -> OutOfRange
                PermissionDenied.errorCode -> PermissionDenied
                ResourceExhausted.errorCode -> ResourceExhausted
                Unauthenticated.errorCode -> Unauthenticated
                Unavailable.errorCode -> Unavailable
                Unimplemented.errorCode -> Unimplemented
                else -> Unknown
            }
        }
    }

    data object Aborted : FirestoreException() {
        override val errorCode: String
            get() = "ABORTED"
    }

    data object AlreadyExists : FirestoreException() {
        override val errorCode: String
            get() = "ALREADY_EXISTS"
    }

    data object Cancelled : FirestoreException() {
        override val errorCode: String
            get() = "CANCELLED"
    }

    data object DataLoss : FirestoreException() {
        override val errorCode: String
            get() = "DATA_LOSS"
    }

    data object DeadlineExceeded : FirestoreException() {
        override val errorCode: String
            get() = "DEADLINE_EXCEEDED"
    }

    data object FailedPrecondition : FirestoreException() {
        override val errorCode: String
            get() = "FAILED_PRECONDITION"
    }

    data object Internal : FirestoreException() {
        override val errorCode: String
            get() = "Internal"
    }

    data object InvalidArgument : FirestoreException() {
        override val errorCode: String
            get() = "INVALID_ARGUMENT"
    }

    data object NotFound : FirestoreException() {
        override val errorCode: String
            get() = "NOT_FOUND"
    }

    data object OutOfRange : FirestoreException() {
        override val errorCode: String
            get() = "OUT_OF_RANGE"
    }

    data object PermissionDenied : FirestoreException() {
        override val errorCode: String
            get() = "PERMISSION_DENIED"
    }

    data object ResourceExhausted : FirestoreException() {
        override val errorCode: String
            get() = "RESOURCE_EXHAUSTED"
    }

    data object Unauthenticated : FirestoreException() {
        override val errorCode: String
            get() = "UNAUTHENTICATED"
    }

    data object Unavailable : FirestoreException() {
        override val errorCode: String
            get() = "UNAVAILABLE"
    }

    data object Unimplemented : FirestoreException() {
        override val errorCode: String
            get() = "UNIMPLEMENTED"
    }

    data object Unknown : FirestoreException() {
        override val errorCode: String
            get() = "UNKNOWN"
    }
}