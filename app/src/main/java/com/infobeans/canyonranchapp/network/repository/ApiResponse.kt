package com.infobeans.canyonranchapp.network.repository

sealed class ApiResponse<T> {
    class Loading<T> : ApiResponse<T>()
    class Success<T>(val data: T) : ApiResponse<T>()

    //    sealed class Error<T>(val message: Pair<String?, String?>?, val data: T? = null) : ApiResponse<T>() {
//        class ApiError<T>(message: Pair<String?, String?>?, data: T? = null) : Error<T>(message, data)
//        class ResponseError<T>(message: Pair<String?, String?>?, data: T? = null) : Error<T>(message, data)
//    }

    //    class Error<T>(val data: T) : ApiResponse<T>()
    class Error<T>(val message: String, val data: T? = null) : ApiResponse<T>()

    //    class Exception<T>(val exception: kotlin.Exception) : ApiResponse<T>()
    class Exception<T>(val exception: String) : ApiResponse<T>()
}


