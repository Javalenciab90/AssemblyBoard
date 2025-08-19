package com.javalenciab90.service

sealed class Response<out T, out E> {
    data class Success<out T>(val data: T) : Response<T, Nothing>()
    data class Error<out E>(val error: E) : Response<Nothing, E>()
}