package com.infobeans.canyonranchapp.screen.navGraph

import androidx.activity.ComponentActivity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.infobeans.canyonranchapp.viewmodel.AuthViewModel

fun NavGraphBuilder.authNavGraph(
    application: ComponentActivity,
    navController: NavHostController,
    viewModel: AuthViewModel
) {

    /*val loadingProgressBar = viewModel.progressBar.value*/

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {

        /*composable(AuthScreen.Splash.route) {
            SplashScreen(navController)
        }*/

//        composable(AuthScreen.Login.route) {
//
//            LoginScreen(
//                application = application,
////                    loadingProgressBar = loadingProgressBar,
//                viewModel = viewModel,
////                    onclick = { viewModel.login(viewModel.textemail,viewModel.textphonenumber) }
////                    imageError = imageError,
//                navController = navController
//            )
//
//        }
//
//        composable(AuthScreen.OTP.route) {
//            OtpScreen(application = application, navController, viewModel)
//        }
    }

}


sealed class AuthScreen(val route: String) {
    /*object Splash : AuthScreen(route = "SPLASH")*/
    object Login : AuthScreen(route = "LOGIN")
    object OTP : AuthScreen(route = "abc")
}