package com.davidorellana.logincomposeretrofit2.network.dto

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("phone")
    val phone: String? = "",

    @SerializedName("code")
    val code: String? = ""

)
