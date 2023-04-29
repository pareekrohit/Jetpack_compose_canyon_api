package com.infobeans.canyonranchapp.screen.ui.my_schedule

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.infobeans.canyonranchapp.utils.custom_calender.common.theme.KalendarShape
import com.infobeans.canyonranchapp.utils.custom_calender.ui.Kalendar
import com.infobeans.canyonranchapp.utils.custom_calender.ui.KalendarType

import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.ui.theme.Chocolate500
import com.infobeans.canyonranchapp.screen.ui.components.ChocolateToolbar
import com.infobeans.canyonranchapp.ui.theme.CanyonRanchAppTheme
import com.infobeans.canyonranchapp.utils.GetStatusBar
import com.infobeans.canyonranchapp.utils.convertStringDateToLocalDate
import com.infobeans.canyonranchapp.viewmodel.DashboardViewModel


@Composable
fun MyScheduleScreenUI(viewModel: DashboardViewModel?) {

    /*val color = if (isSystemInDarkTheme()) SubtitleColor else Color.White*/
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = Chocolate500, darkIcons = false
    )

    CanyonRanchAppTheme(darkTheme = false) {

        Scaffold(
            topBar = {
                ChocolateToolbar(R.string.my_schedule)
                /*Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                )*/
            },
            content = {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    MySchedule(viewModel = viewModel)
                }
            }
        )
    }


    GetStatusBar(
        systemBarColorId = R.color.choclate_500,
        systemBarDarkIcon = false,
        navigationBarColorId = R.color.white,
        navigationBarDarkIcon = true
    )


}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MySchedule(viewModel: DashboardViewModel?) {
    viewModel?.startDate?.let {
        convertStringDateToLocalDate(viewModel.startDate)?.let { startDate ->
            convertStringDateToLocalDate(viewModel.endDate)?.let { endDate ->
                Kalendar(
                    kalendarType = KalendarType.Oceanic(shape = KalendarShape.DefaultRectangle),
                    onCurrentDayClick = { day, event ->
                        //handle the date click listener
                        Log.d("selected date ", "$day $event")
                    },
                    errorMessage = {
                        //Handle the error if any
                    },

                    startDate = startDate,
                    endDate = endDate

                )
            }
        }
    }


}