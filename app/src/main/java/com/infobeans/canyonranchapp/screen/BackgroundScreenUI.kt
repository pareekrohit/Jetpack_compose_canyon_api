package com.infobeans.canyonranchapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.ui.theme.Chocolate500


@Composable
fun BoxExample() {
    Box(modifier = Modifier) {
        val overlayBoxHeight = 40.dp
        Card(
            modifier = Modifier
                .fillMaxSize()
//                .height(300.dp)
        ) {
            //...

            Box(
                Modifier
                    .fillMaxWidth()
//                    .background(Color.DarkGray)
                    .border(BorderStroke(2.dp, Color.Red))
                    .padding(horizontal = 44.dp)
                    .padding(top = 72.dp, bottom = 159.dp)
            ) {
                Text("next view")
            }

        }
        Image(
            painterResource(id = R.drawable.welcome_background),
            contentDescription = "",
            modifier = Modifier
                .width(80.dp)
                .align(BottomStart)
                .padding(start = 11.dp)
//                .offset(x = 0.dp, y =  overlayBoxHeight )
                .padding(bottom = 40.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview_BackgroundScreen() {
    BackgroundScreen_Login_Otp {
//        OtpScreen()
    }

}

@Composable
fun BackgroundScreen_Login_Otp(
    content: @Composable () -> Unit
) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
//                .background(Color(0xFF37C7D7).copy(alpha = 0.6f))
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 44.dp)
                .padding(top = 72.dp, bottom = 159.dp)
                .border(
                    BorderStroke(
                        1.dp,
                        color = Chocolate500.copy(alpha = 0.5f)
                    )
                )

        ) {
            content()
        }

        Image(
            painterResource(id = R.drawable.welcome_background),
            contentDescription = "",
            modifier = Modifier
                .width(80.dp)
                .align(BottomStart)
                .padding(start = 11.dp)
                .padding(bottom = 40.dp),
            contentScale = ContentScale.Fit
        )

    }
}

object HexToJetpackColor {
    fun getColor(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}

