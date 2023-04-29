package com.infobeans.canyonranchapp.utils.custom_calender.ui.oceanic
/*
* MIT License
*
* Copyright (c) 2022 Himanshu Singh
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infobeans.canyonranchapp.utils.custom_calender.common.KalendarKonfig
import com.infobeans.canyonranchapp.utils.custom_calender.common.KalendarStyle
import com.infobeans.canyonranchapp.utils.custom_calender.common.data.KalendarEvent
import com.infobeans.canyonranchapp.utils.custom_calender.common.theme.Grid
import com.infobeans.canyonranchapp.utils.custom_calender.common.theme.KalendarTheme
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun KalendarOceanic(
    kalendarKonfig: KalendarKonfig = KalendarKonfig(),
    kalendarStyle: KalendarStyle = KalendarStyle(),
    /*startDate: LocalDate = LocalDate.now(),*/
    startDate: LocalDate,
    endDate: LocalDate,
    selectedDay: LocalDate = startDate,
    kalendarEvents: List<KalendarEvent>,
    onCurrentDayClick: (LocalDate, KalendarEvent?) -> Unit,
    errorMessageLogged: (String) -> Unit,
) {
    KalendarTheme {
        val color = kalendarStyle.kalendarBackgroundColor ?: KalendarTheme.colors.selectedColor
        val calendarBackgroundColor =
            kalendarStyle.kalendarColor ?: KalendarTheme.colors.background

        /*Card(
            modifier = Modifier
                .background(color)
                .padding(bottom = Grid.One),
            shape = kalendarStyle.shape,
            elevation = kalendarStyle.elevation,
            backgroundColor = calendarBackgroundColor,
        ) {*/
        /*Column(
            modifier = Modifier
                .fillMaxWidth()
                *//*.padding(Grid.OneHalf)*//*
                    .padding(Grid.OneHalf, 5.dp, Grid.OneHalf, 10.dp),
                *//*verticalArrangement = Arrangement.SpaceAround*//*
            ) {*/
        KalendarOceanWeek(
            kalendarSelector = kalendarStyle.kalendarSelector,
            kalendarKonfig = kalendarKonfig,
            startDate = startDate,
            endDate = endDate,
            selectedDay = selectedDay,
            kalendarEvents = kalendarEvents,
            onCurrentDayClick = onCurrentDayClick,
            errorMessageLogged = errorMessageLogged
        )
        /*}*/
        /*}*/
    }
}

/*@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun KalendarOceanPreview(
    modifier: Modifier = Modifier,
    kalendarKonfig: KalendarKonfig = KalendarKonfig(),
) {
    KalendarOceanic(onCurrentDayClick = { _, _ ->
    }, errorMessageLogged = {}, kalendarEvents = emptyList())
}*/


/*
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun Preview() {
    KalendarOceanic(
        onCurrentDayClick = { _, _ ->

        }, errorMessageLogged = {

        }, kalendarEvents = emptyList())

}*/
