package com.infobeans.canyonranchapp.network.repository

import androidx.lifecycle.Transformations.map
import com.davidorellana.logincomposeretrofit2.network.dto.LoginDto
import com.davidorellana.logincomposeretrofit2.network.repository.AuthApiService
import com.infobeans.canyonranchapp.network.dto.ResponseDto
import com.davidorellana.logincomposeretrofit2.network.repository.RetrofitHelper
import com.infobeans.canyonranchapp.network.SharedPreferenceData
import com.infobeans.canyonranchapp.network.dto.asUser
import com.infobeans.canyonranchapp.utils.ErrorCode
import com.infobeans.canyonranchapp.utils.ViewState
import com.skydoves.sandwich.map
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository
//constructor( private val pref: PreferenceStorage,
//    private val dao: UserDao,
//    private val api: AuthApiService, )
{


    fun loginApi(
        body: LoginDto,
    ): Flow<ViewState<ResponseDto>> = flow {
        emit(ViewState.Loading)
        val res = RetrofitHelper.getAuthService().login(body)
//        val res = api.login(body)
        res.suspendOnSuccess {
            emit(ViewState.Success(data.asUser()))
        }.suspendOnError {
            val error = map(ErrorResponseMapper)
            emit(ViewState.Error(error))
        }.suspendOnException {
            emit(ViewState.Error(ErrorCode(1000, "registerApi Exception")))
        }
    }.flowOn(Dispatchers.IO)


    fun verifyOTPApi(
        body: LoginDto,
    ): Flow<ViewState<ResponseDto>> = flow {
        emit(ViewState.Loading)

        val res = RetrofitHelper.getAuthService().verifyOTP(body)
//        val res = api.login(body)
        res.suspendOnSuccess {
            emit(ViewState.Success(data))
        }.suspendOnError {
            val error = map(ErrorResponseMapper)
            emit(ViewState.Error(error))
        }.suspendOnException {
            emit(ViewState.Error(ErrorCode(1000, "registerApi Exception")))
        }
    }.flowOn(Dispatchers.IO)


    fun dashboardProfileApi(): Flow<ViewState<ResponseDto>> = flow {
        emit(ViewState.Loading)

        val res =
            SharedPreferenceData.getLoggedUser()?.data?.token?.let {
                RetrofitHelper.getAuthService().dashboardProfile(
                    "Bearer $it"
                )
            }

        res?.suspendOnSuccess {
            emit(ViewState.Success(data))
        }?.suspendOnError {
            val error = map(ErrorResponseMapper)
            emit(ViewState.Error(error))
        }?.suspendOnException {
            emit(ViewState.Error(ErrorCode(1000, "registerApi Exception")))
        }
    }.flowOn(Dispatchers.IO)


}