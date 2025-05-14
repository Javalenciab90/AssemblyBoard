package com.javalenciab90.service

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error(
        val code: String? = null
    ) : Response<Nothing>()
}