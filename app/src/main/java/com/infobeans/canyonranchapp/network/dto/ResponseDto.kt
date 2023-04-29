package com.infobeans.canyonranchapp.network.dto

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseDto(
//    @SerializedName("success")
    val success: Boolean? = false,
//    @SerializedName("message")
    val message: String? = "",

//    @SerializedName("email")
    var email: String? = "",
//    @SerializedName("phone")
    var phone: String? = "",

//    @SerializedName("data")
    val data: DataDto? = null,

    ) : Parcelable


fun ResponseDto.asUser(): ResponseDto {
    return ResponseDto(
        success = success,
        message = message,
//        username = username,
    )
}


/* "customerFirstName": "Test 2",
        "customerLastName": "Integration",
        "customerFullName": "Test 2 Integration",
        "customerBirthday": "",
        "customerType": "Individual",
        "locationId": 4848806,
        "locationName": "Canyon Ranch Tuscon",
        "tripStartDate": "2022-07-06",
        "tripEndDate": "2022-07-08"*/

@Parcelize
data class DataDto(
    @SerializedName("token")
    var token: String? = "",

    @SerializedName("customerFirstName")
    var firstName: String? = "",

    @SerializedName("customerLastName")
    var lastName: String? = "",

    @SerializedName("customerFullName")
    var fullName: String? = "",

    @SerializedName("customerBirthday")
    var birthday: String? = "",

    @SerializedName("customerType")
    var type: String? = "",

    @SerializedName("locationId")
    var locationID: String? = "",

    @SerializedName("locationName")
    var locationName: String? = "",

    @SerializedName("tripStartDate")
    var tripStartDate: String? = "",

    @SerializedName("tripEndDate")
    var tripEndDate: String? = ""

) : Parcelable
