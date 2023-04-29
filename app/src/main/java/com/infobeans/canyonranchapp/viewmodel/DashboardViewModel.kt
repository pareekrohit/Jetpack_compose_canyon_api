package com.infobeans.canyonranchapp.viewmodel

import android.provider.Settings.Global.getString
import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infobeans.canyonranchapp.MyApplication.Companion.myAppContext
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.network.dto.ResponseDto
import com.infobeans.canyonranchapp.network.repository.Repository
import com.infobeans.canyonranchapp.utils.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class DashboardViewModel : ViewModel() {

    val _dashboardState = MutableStateFlow<ViewState<ResponseDto>>(ViewState.Idle)
    val dashboardState: StateFlow<ViewState<ResponseDto>>
        get() = _dashboardState

    lateinit var startDate: String
    lateinit var endDate: String

    var name: String = ""
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    enum class BottomBarTab {
        HOME,
        MY_SCHEDULE,
        EXPLORE,
        ACCOUNT
    }

    var _currentTab = MutableStateFlow(BottomBarTab.HOME)
    val currentTab: StateFlow<BottomBarTab>
        get() = _currentTab


    fun setTabValue(tab: BottomBarTab) {
        _currentTab.value = tab
    }

    fun dashboardProfile() {
        _dashboardState.tryEmit(ViewState.Idle)
        viewModelScope.launch {
            Repository().dashboardProfileApi().collect {
                _dashboardState.tryEmit(it)
                if (it is ViewState.Success) {
                    // TODO: Call Further API
                    Log.d("Current Time", hour.toString())

                    val greeting: String = if (hour in 12..17) {
                        myAppContext.getString(R.string.good_afternoon)
                    } else if (hour in 18..23) {
                        myAppContext.getString(R.string.good_evening)
                    } /*else if (hour in 21..23) {
                        "Good Night";
                    }*/ else {
                        myAppContext.getString(R.string.good_morning)
                    }

                    name = "$greeting\n${it.data.data?.firstName.toString()}"

                    Log.d("Start date","${it.data.data?.tripStartDate}  ${it.data.data?.tripEndDate}")
                    startDate = it.data.data?.tripStartDate.toString()
                    endDate = it.data.data?.tripEndDate.toString()

                }
            }
        }
    }


}