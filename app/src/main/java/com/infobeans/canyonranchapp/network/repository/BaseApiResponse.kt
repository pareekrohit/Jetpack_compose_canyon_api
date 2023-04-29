package com.infobeans.canyonranchapp.network.repository

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseApiResponse {

    suspend fun <T> firstSafeApiCall(apiCall: suspend () -> Response<T>): ApiResponse<T> {

        try {

            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return ApiResponse.Success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): ApiResponse<T> =
        ApiResponse.Error("Api call failed $errorMessage")


    suspend fun <T> secondSafeApiCall(apiCall: suspend () -> T): ApiResponse<T> {

        return withContext(Dispatchers.IO) {

            try {
//                ApiResponse.Loading
                ApiResponse.Success(apiCall.invoke())

            } catch (throwable: Throwable) {

                when (throwable) {

                    is IOException -> ApiResponse.Exception(throwable.message.toString())

                    is HttpException -> {

                        val code = throwable.code()

//                        val errorResponse = convertErrorBody(throwable)

//                        ResultWrapper.GenericError(code, errorResponse)
                        ApiResponse.Exception("$code  :   ${throwable.message().toString()}")
                    }

                    else -> {

                        ApiResponse.Error("something went wrong")

                    }

                }

            }

        }

    }


}