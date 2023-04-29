package com.infobeans.canyonranchapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit

@Composable
fun Int.scaledSp(): TextUnit {
    val value: Int = this
    return with(LocalDensity.current) {
        val fontScale = this.fontScale
        val textSize = value / fontScale
        textSize.sp
    }
}

@Composable
fun GetStatusBar(
    systemBarColorId: Int,
    systemBarDarkIcon: Boolean,
    navigationBarColorId: Int,
    navigationBarDarkIcon: Boolean
) {
    val systemUiController = rememberSystemUiController()
//    systemUiController.isStatusBarVisible = false // Status bar
//     systemUiController.isNavigationBarVisible = false // Navigation bar
//     systemUiController.isSystemBarsVisible = false // Status & Navigation bars
//     systemUiController.navigationBarDarkContentEnabled =false
    systemUiController.setSystemBarsColor(
        color = colorResource(id = systemBarColorId),
        darkIcons = systemBarDarkIcon
    )
    systemUiController.setNavigationBarColor(
        color = colorResource(id = navigationBarColorId),
        darkIcons = navigationBarDarkIcon
    )

}


object NumberDefaults {
    const val MASK = "(###) ###-####"
    const val INPUT_LENGTH = 10 // Equals to "#####-###".count { it == '#' }
}


@RequiresApi(Build.VERSION_CODES.O)
fun convertStringDateToLocalDate(date: String): LocalDate? {
    /*2022-07-17*/
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return LocalDate.parse(date, formatter)

}

fun noOfDaysBetween(startDate: String, endDate: String): Int {
    var daysDiff: Int = 0
    try {
        // Convert `String` to `Date`
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val dateBefore: Date = sdf.parse(startDate)!!
        val dateAfter: Date = sdf.parse(endDate)!!

        // Calculate the number of days between dates
        val timeDiff: Long = Math.abs(dateAfter.getTime() - dateBefore.getTime())
        daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS).toInt()
        println("between days: $daysDiff")

    } catch (e: Exception) {
        e.printStackTrace()
    }

    return daysDiff
}