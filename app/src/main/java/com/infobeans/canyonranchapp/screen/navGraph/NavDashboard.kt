package com.infobeans.canyonranchapp.screen.navGraph

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.infobeans.canyonranchapp.screen.ui.homedashboard.HomeScreen
import com.infobeans.canyonranchapp.screen.navGraph.bottomBarNav.*
import com.infobeans.canyonranchapp.screen.ui.account.AccountScreen
import com.infobeans.canyonranchapp.screen.ui.homedashboard.ExploreScreen

import com.infobeans.canyonranchapp.screen.ui.my_schedule.MyScheduleScreenUI
import com.infobeans.canyonranchapp.ui.theme.BottomBarColor
import com.infobeans.canyonranchapp.viewmodel.DashboardViewModel

@Composable
fun DashboardScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: DashboardViewModel
) {
    Scaffold(
        backgroundColor = Color.White,
        bottomBar = {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                /* Surface(
                     modifier = Modifier
                         .fillMaxWidth()
                         .wrapContentHeight(),
                     color = Chocolate500,
                     elevation = 20.dp,

                     ) {*/
                Divider(
                    color = BottomBarColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.7.dp)
                )

                AppBottomNavigation(navController = navController)
            }
        }

    ) {
        DashboardNavController(navController, viewModel)
    }
}


@Composable
fun DashboardNavController(navController: NavHostController, viewModel: DashboardViewModel) {
    /*GetStatusBar(
        systemBarColorId = R.color.choclate_500,
        systemBarDarkIcon = false,
        navigationBarColorId = R.color.white,
        navigationBarDarkIcon = true
    )*/

    NavHost(navController = navController, route = Graph.HOME, startDestination = NAV_HOME) {
        composable(NAV_HOME) {
            viewModel.setTabValue(DashboardViewModel.BottomBarTab.HOME)
            HomeScreen(viewModel)
        }
        composable(NAV_MY_SCHEDULE) {
            viewModel.setTabValue(DashboardViewModel.BottomBarTab.MY_SCHEDULE)
            MyScheduleScreenUI(viewModel = viewModel)
        }
        composable(NAV_EXPLORE) {
            viewModel.setTabValue(DashboardViewModel.BottomBarTab.EXPLORE)
            /*AppScreen(text = "Explore Screen")*/
            ExploreScreen(viewModel = viewModel)
        }
        composable(NAV_ACCOUNT) {
            viewModel.setTabValue(DashboardViewModel.BottomBarTab.ACCOUNT)
            AccountScreen(viewModel = viewModel)
        }
    }


}


