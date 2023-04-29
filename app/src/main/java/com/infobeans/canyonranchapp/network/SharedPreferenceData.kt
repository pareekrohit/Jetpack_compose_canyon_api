package com.infobeans.canyonranchapp.network

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.infobeans.canyonranchapp.MyApplication
import com.infobeans.canyonranchapp.MyApplication.Companion.myAppContext
import com.infobeans.canyonranchapp.network.dto.ResponseDto
import com.infobeans.canyonranchapp.utils.Constants

class SharedPreferenceData {

    companion object {
        private const val APP_PREFERENCE_NAME = "CANYON_RANCH_SHARED_PREF"
        private const val PREFERENCE_USER = "PREFERENCE_USER"

        private val sharedPreferences = myAppContext.getSharedPreferences(
            APP_PREFERENCE_NAME, Context.MODE_PRIVATE
        )

        private val editor = sharedPreferences.edit()

        fun getLoggedUser(): ResponseDto? {
            val gson = Gson()
            val json = sharedPreferences.getString(PREFERENCE_USER, "")
            return gson.fromJson(json, ResponseDto::class.java)
        }


        fun saveLoggedUSer(mUser: ResponseDto?) {
            editor.putString(PREFERENCE_USER, Gson().toJson(mUser))
            editor.apply()
            editor.commit()
        }


        /*fun saveProfileData(context: Context, profileDetails: ProfileDetails?) {
        val sharedPreferences = context.getSharedPreferences(
            Constants.APP_PREFERENCE_NAME, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        val data = Gson().toJson(profileDetails)
        editor.putString(Constants.PREFERENCE_USER_PROFILE_PIC, Gson().toJson(profileDetails))
        editor.apply()
        editor.commit()
        Log.d("TAG", "saveProfileData:  data $data")
    }

    fun getProfileData(context: Context): ProfileDetails? {
        val sharedPreferences = context.getSharedPreferences(
            Constants.APP_PREFERENCE_NAME, Context.MODE_PRIVATE
        )
        val gson = Gson()
        val json = sharedPreferences.getString(Constants.PREFERENCE_USER_PROFILE_PIC, "")
        Log.d("TAG", "getProfileData:  " + gson.fromJson(json, ProfileDetails::class.java))
        return gson.fromJson(json, ProfileDetails::class.java)
    }*/

        fun clearSharedPrefData() {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }

    }

}