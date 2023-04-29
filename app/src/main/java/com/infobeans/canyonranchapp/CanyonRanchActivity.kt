package com.infobeans.canyonranchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.infobeans.canyonranchapp.ui.theme.CanyonRanchAppTheme
import com.infobeans.canyonranchapp.viewmodel.AuthViewModel

class CanyonRanchActivity : ComponentActivity() {

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            /*window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )*/
            CanyonRanchAppTheme(darkTheme = false) {
                val navController = rememberNavController()
                GetStatusBar()
                /*ProvideWindowInsets {
                    this.window.statusBarColor = ContextCompat.getColor(this, R.color.white)
                    this.window.navigationBarColor = ContextCompat.getColor(this, R.color.white)*/
//                    GetStatusBar()

                Surface(
                    modifier = Modifier.fillMaxSize(),
//                        color = MaterialTheme.colors.background
                ) {
//                    NavigationScreen(
//                        application = this@CanyonRanchActivity,
//                        navController = navController,
//                        viewModel = viewModel
//                    )
                }
            }
            /*}*/
        }
    }
}


@Composable
fun GetStatusBar() {
    val systemUiController = rememberSystemUiController()
//    systemUiController.isStatusBarVisible = false // Status bar
//     systemUiController.isNavigationBarVisible = false // Navigation bar
//     systemUiController.isSystemBarsVisible = false // Status & Navigation bars
//     systemUiController.navigationBarDarkContentEnabled =false
    systemUiController.setSystemBarsColor(color = Color.White, darkIcons = true)

}










