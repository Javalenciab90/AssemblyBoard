package com.javalenciab90.data.mappers

import com.javalenciab90.service.Response
import com.javalenciab90.domain.Resource

fun <T> Response<T>.toResult(): Resource<T> {
    return when (this) {
        is Response.Success -> Resource.Success(data)
        is Response.Error -> Resource.Error(code = code)
    }
}