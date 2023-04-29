package com.infobeans.canyonranchapp.screen.ui.homedashboard

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.ui.theme.*
import com.infobeans.canyonranchapp.screen.ui.components.ChocolateToolbar
import com.infobeans.canyonranchapp.utils.MaskTransformation
import com.infobeans.canyonranchapp.utils.NumberDefaults
import com.infobeans.canyonranchapp.utils.scaledSp
import com.infobeans.canyonranchapp.viewmodel.DashboardViewModel


@Composable
fun AccountScreen(viewModel: DashboardViewModel?) {


    val systemUiController = rememberSystemUiController()
    /*WindowCompat.setDecorFitsSystemWindows(window, false)*/
    systemUiController.setSystemBarsColor(
        color = Chocolate500, darkIcons = false
    )
    systemUiController.setNavigationBarColor(
        color = Color.White, darkIcons = true
    )
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    var textphonenumber by rememberSaveable { mutableStateOf("1111111111") }
    val focusManager = LocalFocusManager.current


    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 30.dp),
        backgroundColor = Color.White,
        topBar = { ChocolateToolbar(title = R.string.account) },

        ) {
        MaterialTheme() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(Teal200)
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

                    Text(
                        text = stringResource(id = R.string.string_phone),
                        color = FillColor,
                        modifier = Modifier
                            .padding(16.dp, 42.dp, 16.dp, 0.dp),
                        style = TextStyle(
                            fontSize = 18.scaledSp(),
                            fontFamily = FontFamily(
                                Font(R.font.proxima_nova_semi_bold)
                            )
                        ),
                    )

//            Text(
//                text = "(111) 111-1111",
//                color = FillColor,
//                modifier = Modifier
//                    .padding(16.dp, 14.dp, 16.dp, 0.dp),
//                style = TextStyle(
//                    fontSize = 20.scaledSp(),
//                    fontFamily = FontFamily(
//                        Font(R.font.proxima_nova_regular)
//                    )
//                ),
//            )
//            Divider(modifier = Modifier
//                .padding(16.dp, 4.dp, 16.dp, 0.dp), thickness = 1.dp, color = LightColor)

                    BasicTextField(
                        modifier = Modifier.padding(16.dp, 14.dp, 16.dp, 0.dp),
                        value = textphonenumber,
                        enabled = false,
                        readOnly = true,
                        onValueChange = {
                            if (it.length <= 10)
                                textphonenumber = it
                        },
//                decorationBox = { innerTextField ->
//                    Column(
//                        modifier = Modifier
//                    ) {
//                        if (textphonenumber.isEmpty()) {
//                            Text(
//                                stringResource(id = R.string.string_yourphonenumber),
//                                color = LightColor,
//                                fontFamily = FontFamily(Font(R.font.proxima_nova_regular)),
//                                fontWeight = FontWeight.Normal,
//                                fontSize = 20.scaledSp()
//                            )
//                        } else
//                            innerTextField()
//                        Divider(
//                            color = if (textphonenumber.isEmpty()) LightColor else Chocolate500,
//                            modifier = Modifier
//                                .fillMaxWidth(),
//                            thickness = 2.dp
//                        )
//                    }
//                },
                        /*textStyle = TextStyle(
                    fontFamily = FontFamily(Font(R.font.proxima_nova_regular)),
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.scaledSp()
                ),*/
                        textStyle = TextStyle(
                            color = FillColor,
                            fontSize = 20.scaledSp(),
                            fontFamily = FontFamily(
                                Font(R.font.proxima_nova_regular)
                            )
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                            autoCorrect = false
                        ),
                        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                        singleLine = true,
                        maxLines = 1,
                        visualTransformation = MaskTransformation(NumberDefaults.MASK)
                    )

                    Divider(
                        modifier = Modifier
                            .padding(16.dp, 4.dp, 16.dp, 0.dp), thickness = 1.dp, color = LightColor
                    )



                    Text(
                        text = stringResource(id = R.string.string_email),
                        color = FillColor,
                        modifier = Modifier
                            .padding(16.dp, 42.dp, 16.dp, 0.dp),
                        style = TextStyle(
                            fontSize = 18.scaledSp(),
                            fontFamily = FontFamily(
                                Font(R.font.proxima_nova_semi_bold)
                            )
                        ),
                    )

                    Text(
                        text = "hello@canyonranch.com",
                        color = FillColor,
                        modifier = Modifier
                            .padding(16.dp, 14.dp, 16.dp, 0.dp),
                        style = TextStyle(
                            fontSize = 20.scaledSp(),
                            fontFamily = FontFamily(
                                Font(R.font.proxima_nova_regular)
                            )
                        ),
                    )
                    Divider(
                        modifier = Modifier
                            .padding(16.dp, 4.dp, 16.dp, 0.dp), thickness = 1.dp, color = LightColor
                    )

                    Text(
                        text = stringResource(id = R.string.string_dob),
                        color = FillColor,
                        modifier = Modifier
                            .padding(16.dp, 42.dp, 16.dp, 0.dp),
                        style = TextStyle(
                            fontSize = 18.scaledSp(),
                            fontFamily = FontFamily(
                                Font(R.font.proxima_nova_semi_bold)
                            )
                        ),
                    )

                    Text(
                        text = "09/28/1972",
                        color = FillColor,
                        modifier = Modifier
                            .padding(16.dp, 14.dp, 16.dp, 0.dp),
                        style = TextStyle(
                            fontSize = 20.scaledSp(),
                            fontFamily = FontFamily(
                                Font(R.font.proxima_nova_regular)
                            )
                        ),
                    )
                    Divider(
                        modifier = Modifier
                            .padding(16.dp, 4.dp, 16.dp, 40.dp),
                        thickness = 1.dp,
                        color = LightColor
                    )

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(color = Color.White)
                ) {
                    Column(modifier = Modifier.padding(top = 68.dp, bottom = 52.dp)) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id = R.string.string_tnc),
                                color = FillColor,
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                                style = TextStyle(
                                    fontSize = 18.scaledSp(),
                                    fontFamily = FontFamily(
                                        Font(R.font.proxima_nova_semi_bold)
                                    ),
                                    letterSpacing = 2.sp,
                                ),
                            )

                            Image(
                                painter = painterResource(R.drawable.arrow),
                                contentDescription = "right arrow",
                                modifier = Modifier
                                    .width(7.dp)
                                    .height(14.dp)
                                    .weight(0.3f)
                            )
                        }

                        Divider(
                            modifier = Modifier
                                .padding(16.dp, 23.dp, 16.dp, 0.dp),
                            thickness = 1.dp,
                            color = LightColor
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id = R.string.string_privacy),
                                color = FillColor,
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(16.dp, 23.dp, 16.dp, 0.dp),
                                style = TextStyle(
                                    fontSize = 18.scaledSp(),
                                    fontFamily = FontFamily(
                                        Font(R.font.proxima_nova_semi_bold)
                                    ),
                                    letterSpacing = 2.sp,
                                ),
                            )

                            Image(
                                painter = painterResource(R.drawable.arrow),
                                contentDescription = "right arrow",
                                modifier = Modifier
                                    .width(7.dp)
                                    .height(14.dp)
                                    .weight(0.3f)
                            )
                        }
                        Divider(
                            modifier = Modifier
                                .padding(16.dp, 23.dp, 16.dp, 0.dp),
                            thickness = 1.dp,
                            color = LightColor
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id = R.string.string_legal),
                                color = FillColor,
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(16.dp, 23.dp, 16.dp, 0.dp),
                                style = TextStyle(
                                    fontSize = 18.scaledSp(),
                                    fontFamily = FontFamily(
                                        Font(R.font.proxima_nova_semi_bold)
                                    ),
                                    letterSpacing = 2.sp,
                                ),
                            )

                            Image(
                                painter = painterResource(R.drawable.arrow),
                                contentDescription = "right arrow",
                                modifier = Modifier
                                    .width(7.dp)
                                    .height(14.dp)
                                    .weight(0.3f)
                            )
                        }


                        Text(
                            text = stringResource(id = R.string.string_logout),
                            fontSize = 22.scaledSp(),
                            color = Chocolate500,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 95.5.dp, 0.dp, 0.dp)
                                .clickable {  },
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                letterSpacing = 2.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.proxima_nova_regular)
                                ),
                            )

                        )

                        Text(
                            text = "VERSION 1.0",
                            color = FillColor,
                            modifier = Modifier
                                .fillMaxWidth()
//                                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                                .padding(0.dp, 10.dp, 0.dp, 52.dp)
                            ,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.scaledSp(),
                                fontFamily = FontFamily(
                                    Font(R.font.proxima_nova_semi_bold)
                                ),
                                letterSpacing = 2.sp,
                            ),
                        )


                    }


/*
                    Text(
                        text = "LOG OUT",
                        fontSize = 22.scaledSp(),
                        color = CardBorderColor,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(0.dp, 95.5.dp, 0.dp, 39.dp),
                        style = TextStyle(
                            letterSpacing = 2.sp,
                            fontFamily = FontFamily(
                                Font(R.font.proxima_nova_regular)
                            ),
                        )

                    )
*/


                }
            }
        }

    }

}
