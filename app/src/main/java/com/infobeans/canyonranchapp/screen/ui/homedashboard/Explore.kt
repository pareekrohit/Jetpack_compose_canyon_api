package com.infobeans.canyonranchapp.screen.ui.homedashboard

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.screen.ui.account.AccountUI
import com.infobeans.canyonranchapp.screen.ui.components.ChocolateToolbar
import com.infobeans.canyonranchapp.ui.theme.CanyonRanchAppTheme
import com.infobeans.canyonranchapp.ui.theme.Chocolate500
import com.infobeans.canyonranchapp.utils.scaledSp
import com.infobeans.canyonranchapp.viewmodel.DashboardViewModel

@Composable
fun ExploreScreen(viewModel: DashboardViewModel?) {


    val systemUiController = rememberSystemUiController()
    /*WindowCompat.setDecorFitsSystemWindows(window, false)*/
    systemUiController.setSystemBarsColor(
        color = Chocolate500, darkIcons = false
    )

    systemUiController.setNavigationBarColor(
        color = Color.White, darkIcons = true
    )

    CanyonRanchAppTheme(darkTheme = false) {

        Scaffold(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            topBar = { ChocolateToolbar(title = R.string.explore) },

            ) {
            Text(
                text = "Jennifer Smith",
                color = Color.Black,
                modifier = Modifier
                    .padding(16.dp, 40.dp, 16.dp, 0.dp)
                    .height(48.dp),
                style = TextStyle(
                    fontSize = 36.scaledSp(),
                    fontFamily = FontFamily(
                        Font(R.font.cormorant_garamond_regular)
                    )
                ),
            )
        }
    }

}