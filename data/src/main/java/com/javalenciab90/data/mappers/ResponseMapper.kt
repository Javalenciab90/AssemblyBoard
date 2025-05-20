package com.javalenciab90.data.mappers

import com.javalenciab90.service.Response
import com.javalenciab90.domain.Result

fun <T> Response<T>.toResult(): Result<T> {
    return when (this) {
        is Response.Success -> Result.Success(data)
        is Response.Error -> Result.Error(code = code)
    }
}