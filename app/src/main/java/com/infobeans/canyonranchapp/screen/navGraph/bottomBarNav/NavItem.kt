package com.infobeans.canyonranchapp.screen.navGraph.bottomBarNav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.infobeans.canyonranchapp.R

sealed class NavItem(@StringRes val title: Int,
                     @DrawableRes val icon: Int,
                     val navRoute: String){

    object Home : NavItem(R.string.home, R.drawable.home, NAV_HOME)
    object MySchedule : NavItem(R.string.my_schedule, R.drawable.my_schdule, NAV_MY_SCHEDULE)
    object Explore : NavItem(R.string.explore, R.drawable.explore, NAV_EXPLORE)
    object Account : NavItem(R.string.account, R.drawable.account, NAV_ACCOUNT)

}
