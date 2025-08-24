package com.javalenciab90.data.mappers

import com.javalenciab90.domain.Resource
import com.javalenciab90.service.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun <T, E> Response<T, E>.toResource(): Resource<T, E> {
    return when (this) {
        is Response.Success -> Resource.Success(data)
        is Response.Error -> Resource.Error(error)
    }
}

/**
 * Maps a Flow of a generic Response to a Flow of a generic Resource.
 *
 * @param E The type of the final exception (e.g., AuthFirebaseException, FirestoreException).
 * @param errorMapper A function that maps a String error code to an exception of type E.
 */
fun <T, E> Flow<Response<T, String>>.toResourceFlow(
    errorMapper: (String) -> E
): Flow<Resource<T, E>> {
    return this.map { response ->
        when (response) {
            is Response.Success -> Resource.Success(response.data)
            is Response.Error -> {
                val exception = errorMapper(response.error)
                Resource.Error(exception)
            }
        }
    }
}

/**
 * Maps a Flow of a generic Response to a Flow of a generic Resource.
 * Handles both data and error transformations.
 *
 * @param T The original type of the data in the Response (e.g., FirebaseUser).
 * @param R The final type of the data in the Resource (e.g., UserProfile).
 * @param E The final type of the exception (e.g., AuthFirebaseException).
 * @param dataMapper A function that maps the successful data from type T to R.
 * @param errorMapper A function that maps a String error code to an exception of type E.
 */
fun <T, R, E> Flow<Response<T, String>>.mapToResourceFlow(
    dataMapper: (T) -> R,
    errorMapper: (String) -> E
): Flow<Resource<R, E>> {
    return this.map { response ->
        when (response) {
            is Response.Success -> {
                val mappedData = dataMapper(response.data)
                Resource.Success(mappedData)
            }
            is Response.Error -> {
                val exception = errorMapper(response.error)
                Resource.Error(exception)
            }
        }
    }
}