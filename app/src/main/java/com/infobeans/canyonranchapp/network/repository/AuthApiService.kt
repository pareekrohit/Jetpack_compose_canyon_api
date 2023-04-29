package com.davidorellana.logincomposeretrofit2.network.repository

import com.davidorellana.logincomposeretrofit2.network.dto.LoginDto
import com.infobeans.canyonranchapp.network.dto.ResponseDto
import com.skydoves.sandwich.ApiResponse
//import com.infobeans.canyonranchapp.network.repository.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApiService {

//    @POST("v1/login")
//    suspend fun getLogin(@Body loginDto: LoginDto): Response<ResponseDto>
//
//    @POST("v1/login")
//    suspend fun postLogin(@Body loginDto: LoginDto): ApiResponse<ResponseDto>
//
//    @POST("v1/login")
//    suspend fun gpostLogin(@Body loginDto: LoginDto): ResponseDto

    @POST("v1/login")
    suspend fun login(@Body body: LoginDto): ApiResponse<ResponseDto>

    @POST("v1/authorization")
    suspend fun verifyOTP(@Body body: LoginDto): ApiResponse<ResponseDto>

    @GET("v1/profile")
    suspend fun dashboardProfile(@Header("Authorization") authorization: String): ApiResponse<ResponseDto>


}