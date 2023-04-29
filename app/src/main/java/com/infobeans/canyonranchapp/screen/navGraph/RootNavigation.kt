package com.infobeans.canyonranchapp.screen.navGraph

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.infobeans.canyonranchapp.viewmodel.AuthViewModel

@Composable
fun NavigationScreen(application: ComponentActivity, navController: NavHostController, viewModel: AuthViewModel) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASH
    ) {

//        composable(Graph.SPLASH){
//            SplashScreen(navController)
//        }
//        authNavGraph(application,navController,viewModel)
//        composable(Graph.HOME) {
//            DashboardScreen()
//        }

    }
}


object Graph {
    const val ROOT = "root_graph"
    const val SPLASH = "splash_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"

}