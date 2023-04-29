package com.infobeans.canyonranchapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidorellana.logincomposeretrofit2.network.repository.RetrofitHelper
import com.davidorellana.logincomposeretrofit2.network.dto.LoginDto
import com.infobeans.canyonranchapp.network.dto.ResponseDto
import com.infobeans.canyonranchapp.network.repository.Repository
import com.infobeans.canyonranchapp.utils.ViewState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel
//constructor(private val repository: Repository)
    : ViewModel() {

    var textemail by mutableStateOf("")
    var textphonenumber by mutableStateOf("")
    val isSuccessLoading = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    private val loginRequestLiveData = MutableLiveData<Boolean>()


    val _loginState = MutableStateFlow<ViewState<ResponseDto>>(ViewState.Idle)
    val loginState: StateFlow<ViewState<ResponseDto>>
        get() = _loginState

    fun performLogin(email: String, phone: String) {
        _loginState.tryEmit(ViewState.Idle)
        viewModelScope.launch {
            Repository().loginApi(LoginDto(email = email, phone = phone)).collect {
                _loginState.tryEmit(it)
                if (it is ViewState.Success) {
                    // TODO: Call Further API
                }
            }
        }
    }


    fun performOTP(email: String, phone: String, otp: String) {
        _loginState.tryEmit(ViewState.Idle)
        viewModelScope.launch {
            Repository().verifyOTPApi(LoginDto(email = email, phone = phone, code = otp)).collect {
                _loginState.tryEmit(it)
                if (it is ViewState.Success) {
                    // TODO: Call Further API
                }
            }
        }
    }



}