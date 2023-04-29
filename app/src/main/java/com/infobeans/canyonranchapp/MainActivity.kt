package com.infobeans.canyonranchapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.rememberNavController
import com.infobeans.canyonranchapp.ui.theme.CanyonRanchAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // TODO: for Black Notif Icon
//            this.window.decorView.windowInsetsController?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
            // TODO: for White Notif Icon
//            this.window.decorView.windowInsetsController?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)
//        }




    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}