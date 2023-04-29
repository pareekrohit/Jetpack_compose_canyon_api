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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.utils.custom_calender.common.KalendarKonfig
import com.infobeans.canyonranchapp.utils.custom_calender.common.KalendarSelector
import com.infobeans.canyonranchapp.utils.custom_calender.common.data.KalendarEvent
import com.infobeans.canyonranchapp.utils.custom_calender.common.theme.DisabledDateColor
import com.infobeans.canyonranchapp.utils.custom_calender.common.theme.KalendarShape
import com.infobeans.canyonranchapp.utils.custom_calender.common.ui.KalendarDot
import com.infobeans.canyonranchapp.utils.noOfDaysBetween
import com.infobeans.canyonranchapp.utils.scaledSp
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

/*@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun Preview() {
    KalendarOceanWeek(
        onCurrentDayClick = { _, _ ->

        }, errorMessageLogged = {

        }, kalendarEvents = emptyList(),
        kalendarKonfig = KalendarKonfig(),
        kalendarSelector = KalendarStyle().kalendarSelector
    )

}*/

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun KalendarOceanWeek(
    /*startDate: LocalDate = LocalDate.now(),*/
    startDate: LocalDate,
    endDate: LocalDate,
    selectedDay: LocalDate = startDate,
    kalendarKonfig: KalendarKonfig,
    onCurrentDayClick: (LocalDate, KalendarEvent?) -> Unit,
    errorMessageLogged: (String) -> Unit,
    kalendarSelector: KalendarSelector,
    kalendarEvents: List<KalendarEvent>,
) {

    val isDot = kalendarSelector is KalendarSelector.Dot
    val haptic = LocalHapticFeedback.current
    val displayWeek = remember {
        /*mutableStateOf(startDate.getNext7Dates())*/
        mutableStateOf(getInBetweenDate(startDate, endDate))
    }
    val clickedDate = remember {
        mutableStateOf(selectedDay)
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val size = (maxWidth / 7)
        val monthName = "${
            displayWeek.value.last().month.getDisplayName(
                TextStyle.FULL,
                kalendarKonfig.locale
            )
        } ${displayWeek.value.last().year}"

        Column(Modifier.fillMaxWidth().height(75.dp)) {

            /*KalendarOceanHeader(
                */
            /**Month name and year on top*//*
                monthName,
                displayWeek,
                haptic,
                kalendarKonfig.yearRange,
                errorMessageLogged
            )*/


            LazyRow() {
                items(displayWeek.value) { date ->
                    val isSelected = date == clickedDate.value

                    SetCalender(
                        size,
                        date,
                        endDate,
                        kalendarKonfig,
                        kalendarSelector,
                        isDot,
                        isSelected,
                        kalendarEvents,
                        haptic,
                        clickedDate,
                        onCurrentDayClick
                    )
                }
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetCalender(
    size: Dp,
    date: LocalDate,
    endDate: LocalDate,
    kalendarKonfig: KalendarKonfig,
    kalendarSelector: KalendarSelector,
    isDot: Boolean,
    isSelected: Boolean,
    kalendarEvents: List<KalendarEvent>,
    haptic: HapticFeedback,
    clickedDate: MutableState<LocalDate>,
    onCurrentDayClick: (LocalDate, KalendarEvent?) -> Unit
) {

    Column(
        modifier = Modifier.padding(0.dp, 11.5.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val event: KalendarEvent? = kalendarEvents.find { it.date == date }
        val isPreviousDate = LocalDate.now().isAfter(date)

        //LocalDate
        val isAfterDate = date.isAfter(endDate)

        /**Days*/
        Text(
            text = date.dayOfWeek
                .getDisplayName(TextStyle.FULL, kalendarKonfig.locale).toString().uppercase()
                .subSequence(0, kalendarKonfig.weekCharacters).toString(),
            style = androidx.compose.ui.text.TextStyle(
                letterSpacing = 1.sp,
                fontSize = 15.scaledSp(),
                fontFamily = FontFamily(
                    Font(R.font.proxima_nova_semi_bold)
                )
            ),
            modifier = Modifier
                .width(size)
                .wrapContentHeight(),
            textAlign = TextAlign.Center,
            color = getTextColor(
                isSelected, kalendarSelector, event != null,
                isPrevDate = isPreviousDate,
                isAfterDate
            )
            /*color = TextColor*/
        )

        //Dates
        Text(
            text = date.dayOfMonth.toString(),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 15.scaledSp(),
                fontFamily = FontFamily(
                    Font(R.font.proxima_nova_medium)
                ),
                letterSpacing = 1.sp,
            ),
            /*fontWeight = FontWeight.SemiBold,*/
            color = getTextColor(
                isSelected,
                kalendarSelector,
                event != null,
                isPreviousDate,
                isAfterDate
            ),
            modifier = Modifier
//                .size(size)
                .clip(if (isDot) KalendarShape.DefaultRectangle else kalendarSelector.shape)
                /*.background(
                    if (!isDot) {
                        getBackgroundColor(
                            kalendarSelector = kalendarSelector,
                            selectedDate = clickedDate.value,
                            providedDate = date
                        )
                    } else Color.Transparent
                )*/
                .clickable {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    clickedDate.value = date
                    onCurrentDayClick(date, event)
                }
                .wrapContentHeight().padding(top = 4.dp, bottom = 5.dp),
            textAlign = TextAlign.Center
        )


        if (isDot) {  //dot customization
            KalendarDot(
                kalendarSelector = kalendarSelector,
                isSelected = isSelected,
                isToday = date == LocalDate.now()
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
internal fun getInBetweenDate(startDate: LocalDate, endDate: LocalDate): List<LocalDate> {
    var endtripDate = endDate
    var noDays = noOfDaysBetween(startDate.toString(), endDate.toString())
    /*if (noDays != 7) {
        endtripDate
    }*/

    /*if (noDays % 7 != 0) {   //less than 7 days
        Log.d("not divisible", "true")
    }*/

    /*var number: Int = noDays / 7
    var reminder: Int = noDays % 7

    var missingDays: Int = 0
    if (reminder != 0) {
        missingDays = (7 - reminder) - 1
    } else {
        missingDays = reminder
    }*/


    /*Log.d("Missing_Days", "$missingDays")*/


    var start = startDate    /*LocalDate.parse(startDate)*/
    val end = endDate /*LocalDate.parse("2022-07-31")*/       /*LocalDate.parse(endDate)*/
    val totalDates: MutableList<LocalDate> = ArrayList()
    while (!start.isAfter(end)) {
        totalDates.add(start)
        start = start.plusDays(1)
    }

    var missingDays: Int = 0
    if (noDays < 7) {
        missingDays = (7 - noDays) - 1
        Log.d("Missing_Days", "$missingDays")
    }


    for (i in 1..missingDays) {
        endtripDate = LocalDate.parse(endtripDate.toString()).plusDays(1)
        totalDates.add(endtripDate)
    }

    return totalDates
}


@RequiresApi(Build.VERSION_CODES.O)
private fun getBackgroundColor(
    selectedDate: LocalDate,
    providedDate: LocalDate,
    kalendarSelector: KalendarSelector,
): Color {
    return if (providedDate == LocalDate.now()) {
        when (selectedDate) {
            providedDate -> kalendarSelector.selectedColor
            else -> kalendarSelector.todayColor
        }
    } else {
        when (selectedDate) {
            providedDate -> kalendarSelector.selectedColor
            else -> kalendarSelector.defaultColor
        }
    }
}

private fun getTextColor(
    isSelected: Boolean,
    kalendarSelector: KalendarSelector,
    isEvent: Boolean,
    isPrevDate: Boolean,
    isAfterDate: Boolean,
): Color {

    return when {
        isEvent -> kalendarSelector.eventTextColor
        isPrevDate && isSelected -> kalendarSelector.selectedTextColor
        isPrevDate -> DisabledDateColor
        isAfterDate -> DisabledDateColor

        else -> when {
            isSelected -> kalendarSelector.selectedTextColor
            else -> kalendarSelector.defaultTextColor
        }
    }

}
