package com.infobeans.canyonranchapp.screen.navGraph.bottomBarNav

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.ui.theme.Chocolate500
import com.infobeans.canyonranchapp.ui.theme.LightColor
import com.infobeans.canyonranchapp.utils.scaledSp

@Composable
fun AppBottomNavigation(navController: NavController) {

    val navItems = listOf(NavItem.Home, NavItem.MySchedule, NavItem.Explore, NavItem.Account)

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        modifier = Modifier
            .fillMaxWidth()
            .height(63.dp),
        elevation = 8.dp,

        ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    if (currentRoute == item.navRoute) {
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                color = Chocolate500,
                                modifier = Modifier
                                    .width(63.dp)
                                    .height(4.dp)
                                /*,*/
                                /*thickness = 8.dp*/
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = stringResource(item.title)
                            )
                        }
                    } else {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = stringResource(item.title),
                            tint = Color.Black
                        )
                    }

                },
                label = {
                    Text(
                        text = stringResource(item.title),
                        style = TextStyle(
                            fontSize = 11.scaledSp(),
                            fontFamily = FontFamily(
                                Font(R.font.proxima_nova_medium)
                            )
                        ),
                    )
                },
                selectedContentColor = Chocolate500,
                unselectedContentColor = Color.Black,
                alwaysShowLabel = true,
                selected = currentRoute == item.navRoute,
                onClick = {
                    navController.navigate(item.navRoute) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

            )
        }
    }
}