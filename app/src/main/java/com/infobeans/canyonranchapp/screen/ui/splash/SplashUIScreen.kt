package com.infobeans.canyonranchapp.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.screen.navGraph.Graph
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController?) {
    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController?.navigate(Graph.AUTHENTICATION) {
            popUpTo(Graph.SPLASH) {
                inclusive = true
            }
        }
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxSize()
                .padding(70.dp),
        )

        /* Image(
             painter = painterResource(id = R.drawable.ic_a),
             contentDescription = "Logo",
             contentScale= ContentScale.Crop,
         )


         Image(
             painter = painterResource(id = R.drawable.ic__n),
             contentDescription = "Logo",
             contentScale= ContentScale.Crop,
         )


         Image(
             painter = painterResource(id = R.drawable.ic_y),
             contentDescription = "Logo",
             contentScale= ContentScale.Crop,
         )

         Image(
             painter = painterResource(id = R.drawable.ic_o),
             contentDescription = "Logo",
             contentScale= ContentScale.Crop,
         )

         Image(
             painter = painterResource(id = R.drawable.ic__n),
             contentDescription = "Logo",
             contentScale= ContentScale.Crop,
         )

         Image(
             painter = painterResource(id = R.drawable.ic_r),
             contentDescription = "Logo",
             contentScale= ContentScale.Crop,
         )

         Image(
             painter = painterResource(id = R.drawable.ic_a),
             contentDescription = "Logo",
              contentScale= ContentScale.Crop,
         )

         Image(
             painter = painterResource(id = R.drawable.ic__n),
             contentDescription = "Logo",
             contentScale= ContentScale.Crop,
         )

         Image(
             painter = painterResource(id = R.drawable.ic__c),
             contentDescription = "Logo",
              contentScale= ContentScale.Crop,
         )

         Image(
             painter = painterResource(id = R.drawable.ic_h),
             contentDescription = "Logo",
              contentScale= ContentScale.Crop,
         )
     }*/
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        SplashScreen(null)
    }
}


