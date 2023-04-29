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
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.text.style.TextAlign
import com.himanshoe.kalendar.util.validateMaxDate
import com.himanshoe.kalendar.util.validateMinDate
import com.infobeans.canyonranchapp.utils.custom_calender.common.YearRange
import com.infobeans.canyonranchapp.utils.custom_calender.common.theme.Grid
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

/*@Preview
@Composable
fun HeaderPreview() {
}*/

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun KalendarOceanHeader(
    text: String,
    displayWeek: MutableState<List<LocalDate>>,
    haptic: HapticFeedback,
    yearRange: YearRange,
    errorMessageLogged: (String) -> Unit,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = Grid.One, bottom = Grid.Two),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.align(Alignment.CenterVertically),
            color = Color.Black,
            textAlign = TextAlign.Justify
        )


        Row(
            modifier = Modifier.alpha(0.6F),
            horizontalArrangement = Arrangement.End,
        ) {
            KalendarOceanButton(
                Modifier,
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Previous Week",
                onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    val firstDayOfWeek = displayWeek.value.first()
                    val isLimitAttached = firstDayOfWeek.year.validateMinDate(yearRange.min)
                    if (isLimitAttached) {
                        displayWeek.value = firstDayOfWeek.getPrevious7Dates()
                    } else {
                        errorMessageLogged("Minimum year limit reached")
                    }
                }
            )
            KalendarOceanButton(
                Modifier,
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Next Month",
                onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    val lastDayOfWeek = displayWeek.value.last()
                    val isLimitAttached = lastDayOfWeek.year.validateMaxDate(yearRange.max)
                    if (isLimitAttached) {
                        displayWeek.value = lastDayOfWeek.getNext7Dates()
                    } else {
                        errorMessageLogged("Maximum year limit reached")
                    }
                    /*val lastDayOfWeek = displayWeek.value.last()
                    displayWeek.value = lastDayOfWeek.getInBetweenDate()*/

                }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun KalendarOceanButton(
    modifier: Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .clip(CircleShape)
    ) {
        Icon(
            modifier = Modifier
                .alpha(0.5F),
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
internal fun LocalDate.getNext7Dates(): List<LocalDate> {
    val dates = mutableListOf<LocalDate>()
    repeat(7) { day ->
        dates.add(this.plusDays(day.toLong()))
    }
    return dates
}

@RequiresApi(Build.VERSION_CODES.O)
internal fun LocalDate.getPrevious7Dates(): List<LocalDate> {
    val dates = mutableListOf<LocalDate>()
    repeat(7) { day ->
        dates.add(this.minusDays(day.toLong()))
    }
    return dates.reversed()
}


/*@RequiresApi(Build.VERSION_CODES.O)
internal fun LocalDate.getInBetweenDate(): List<LocalDate> {
    val s = "2014-05-01"
    val e = "2014-05-10"
    var start = LocalDate.parse(s)
    val end = LocalDate.parse(e)
    val totalDates: MutableList<LocalDate> = ArrayList()
    while (!start.isAfter(end)) {
        totalDates.add(start)
        start = start.plusDays(1)
    }
    return totalDates
}*/


/*internal fun getDaysBetweenDates(*//*startdate: Date?, enddate: Date?*//*): List<Date> {

    val startdate = "2014-05-01"
    val enddate = "2014-05-10"

    val dates: MutableList<Date> = ArrayList<Date>()
    val calendar: Calendar = GregorianCalendar()
    calendar.setTime(startdate)
    while (calendar.getTime().before(enddate)) {
        val result: Date = calendar.getTime()
        dates.add(result)
        calendar.add(Calendar.DATE, 1)
    }
    return dates
}*/




