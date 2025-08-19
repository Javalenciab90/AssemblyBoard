package com.javalenciab90.domain

sealed class Resource<out T, out E> {
    data class Success<out T>(val data: T) : Resource<T, Nothing>()
    data class Error<out E>(val error: E) : Resource<Nothing, E>()
}