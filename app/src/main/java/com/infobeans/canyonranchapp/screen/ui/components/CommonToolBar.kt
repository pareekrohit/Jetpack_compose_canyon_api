package com.infobeans.canyonranchapp.screen.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.ui.theme.Chocolate500
import com.infobeans.canyonranchapp.utils.scaledSp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChocolateToolbar(title: Int) {
    TopAppBar(
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth(),
        title = {
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = stringResource(id = title),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 30.scaledSp(),
                            fontFamily = FontFamily(
                                Font(R.font.cormorant_garamond_regular)
                            )
                        )
                    )
                }
            }
        },
        contentColor = Color.White,
        backgroundColor = Chocolate500,
        elevation=10.dp
        )
}

