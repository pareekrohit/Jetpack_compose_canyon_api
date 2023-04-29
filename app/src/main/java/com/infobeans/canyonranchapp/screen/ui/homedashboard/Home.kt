package com.infobeans.canyonranchapp.screen.ui.homedashboard


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.ui.theme.*
import com.infobeans.canyonranchapp.utils.scaledSp
import com.infobeans.canyonranchapp.viewmodel.DashboardViewModel


@Composable
fun AppScreen(text: String) {
    /*GetStatusBar(
        systemBarColorId = R.color.choclate_500,
        systemBarDarkIcon = false,
        navigationBarColorId = R.color.white,
        navigationBarDarkIcon = true
    )*/
    val color = if (isSystemInDarkTheme()) SubtitleColor else Color.White
    Text(
        text = "Hello $text",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
        textAlign = TextAlign.Center,
        color = color
    )
}


@Preview
@Composable
fun DefaultPreview() {
    HomeScreen(null)
}


@Composable
fun HomeScreen(viewModel: DashboardViewModel?) {


    val systemUiController = rememberSystemUiController()
    /*WindowCompat.setDecorFitsSystemWindows(window, false)*/
    systemUiController.setSystemBarsColor(
        color = Color.Transparent, darkIcons = true
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
        ) {
            Image(
                painter = painterResource(R.drawable.dashboard_img),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp, 0.dp, 0.dp, 20.dp),
                contentScale = ContentScale.Crop
            )

           /* var fullName: String = ""
            val dashboardState = viewModel?.dashboardState?.collectAsState()?.value
            when (dashboardState) {
                is ViewState.Loading -> ProgressScreen()
                is ViewState.Success -> {
                    if (dashboardState.data.success == true) {
                        fullName = dashboardState.data.data?.fullName.toString()
                    }
                }
            }*/

            viewModel?.name?.let {
                Text(
                    text = it,
                    fontSize = 45.scaledSp(),
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(32.dp, 0.dp, 33.dp, 80.dp),
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(0f, 2f),
                            blurRadius = 1F,
                        ),
                        fontFamily = FontFamily(
                            Font(R.font.cormorant_garamond_regular)
                        ),

                        )
                )
            }

            Card(
                shape = RoundedCornerShape(3.dp),
                border = BorderStroke(1.dp, CardBorderColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(20.dp, 0.dp),

                elevation = 3.dp,
                backgroundColor = Color.White
            ) {
                Text(
                    text = stringResource(R.string.view_your_schedule),
                    fontSize = 18.scaledSp(),
                    color = Chocolate500,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(13.dp, 12.dp),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        letterSpacing = 2.sp,
                        fontSize = 18.scaledSp(),
                        fontFamily = FontFamily(
                            Font(R.font.proxima_nova_semi_bold)
                        )
                    ),
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(LightThemeColor)
        ) {

            Text(
                text = stringResource(id = R.string.explore),
                color = SubtitleColor,
                modifier = Modifier
                    .padding(22.dp, 20.dp, 22.dp, 10.dp),
                style = TextStyle(
                    letterSpacing = 2.sp,
                    fontSize = 18.scaledSp(),
                    fontFamily = FontFamily(
                        Font(R.font.proxima_nova_semi_bold)
                    )
                ),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(0.dp, 0.dp)
            ) {


                Box(
                    modifier = Modifier
                        .padding(22.dp, 0.dp, 5.dp, 0.dp)
                        .height(170.dp)
                        .weight(1f)
                        .background(Chocolate500),
                ) {

                    Image(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        painter = painterResource(id = R.drawable.things_to_do),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = stringResource(R.string.things_to_do),
                        fontSize = 22.scaledSp(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        /*style = MaterialTheme.typography.h3,*/
                        modifier = Modifier
                            .align(Alignment.Center),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.proxima_nova_medium)),
                            shadow = Shadow(
                                color = ShadowThingToDoColor,
                                offset = Offset(0f, 0.5f),
                                blurRadius = 1F,
                            )
                        )
                    )

                }


                Box(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 22.dp, 0.dp)
                        .height(170.dp)
                        .weight(1f)
                        .background(Chocolate500)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ranch_schedule),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = stringResource(R.string.ranch_schdule),
                        fontSize = 22.scaledSp(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        /*fontFamily = FontFamily(
                            Font(R.font.proxima_nova_medium)
                        ),*/
                        /*style = MaterialTheme.typography.h3,*/
                        modifier = Modifier
                            .align(Alignment.Center),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.proxima_nova_medium)),
                            shadow = Shadow(
                                color = ShadowThingToDoColor,
                                offset = Offset(0f, 0.5f),
                                blurRadius = 1F,
                            )
                        )
                    )
                }

            }
        }


    }

}
