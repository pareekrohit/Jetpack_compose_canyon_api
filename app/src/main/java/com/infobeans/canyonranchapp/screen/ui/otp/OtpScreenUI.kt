package com.infobeans.canyonranchapp.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.screen.navGraph.AuthScreen
import com.infobeans.canyonranchapp.screen.navGraph.Graph
import com.infobeans.canyonranchapp.ui.theme.Chocolate500
import com.infobeans.canyonranchapp.ui.theme.FillColor
import com.infobeans.canyonranchapp.ui.theme.LightColor
import com.infobeans.canyonranchapp.ui.theme.SubtitleColor
import com.infobeans.canyonranchapp.utils.Helper
import com.infobeans.canyonranchapp.utils.scaledSp


@Composable
fun OtpScreen(
    verifyOTPPress: (textOTP: String) -> Unit
    /*application: ComponentActivity, navController: NavHostController, viewModel: LoginViewModel*/
) {

    BackgroundScreen_Login_Otp {
        OtpScreenUI(/*navController = navController*/
            verifyOTPPress
        )
    }
}

@Composable
fun OtpScreenUI(
    verifyOTPPress: (textOTP: String) -> Unit
/*modifier: Modifier = Modifier, navController: NavHostController*/
) {
    val context = LocalContext.current
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val maxChar = 6
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp)
            .padding(top = 58.dp)
    ) {
        Text(
            text = stringResource(id = R.string.string_pleaseverify),
            fontSize = 36.scaledSp(),
            fontWeight = FontWeight(400),
            fontFamily = FontFamily(
                Font(R.font.cormorant_garamond_regular)
            ),
            color = SubtitleColor,
            lineHeight = 32.scaledSp(),
            softWrap = true,
        )
        Text(
            text = stringResource(id = R.string.string_entersixdigitcode),
            modifier = Modifier.padding(top = 20.dp),
            fontSize = 18.scaledSp(),
            color = SubtitleColor,
            fontFamily = FontFamily(
                Font(R.font.proxima_nova_regular)
            ),
            style = typography.body2
        )
        Text(
            text = stringResource(id = R.string.string_verificationcode),
            modifier = Modifier.padding(top = 42.dp),
            color = FillColor,
            style = TextStyle(
                letterSpacing = 2.sp,
                fontSize = 18.scaledSp(),
                fontFamily = FontFamily(
                    Font(R.font.proxima_nova_regular)
                )
            ),
        )

        /*TextField(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(all = 0.dp),
//                .background(Color.White)
            value = password,
            onValueChange = { if (it.length <= maxChar) password = it },
//            label = { Text(text = "Password") },
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f)
//            ),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.White,
                focusedIndicatorColor = Chocolate500,
                unfocusedIndicatorColor = LightColor,
                disabledIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            placeholder = { Text(text = "----", color = LightColor) },
            visualTransformation =
            if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(onDone = { *//* TODO *//* }),
            leadingIcon = null,
            *//*trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            }*//*
        )*/

        BasicTextField(
            modifier = Modifier.padding(top = (12.dp)),
            value = password,
            onValueChange = { if (it.length <= maxChar) password = it },
            decorationBox = { innerTextField ->

                Column(
                    modifier = Modifier
                ) {
                    if (password.isEmpty()) {
                        Text("----", color = LightColor)
                    } else
                        innerTextField()
                    Divider(
                        color = if (password.isEmpty()) LightColor else Chocolate500,
                        modifier = Modifier
                            .fillMaxWidth(),
                        thickness = 2.dp
                    )
                }

            },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.proxima_nova_regular)),
                fontWeight = FontWeight.Normal,
                fontSize = 20.scaledSp()
            ),
            visualTransformation =
            if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),

            )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                modifier = Modifier
                    .width(186.dp)
                    .height(51.dp),
                onClick = {
//                    navController.navigate(Graph.HOME)
                    /* navController?.navigate(Graph.HOME) {
                         popUpTo(AuthScreen.OTP.route) {
                             inclusive = true
                         }
                     }*/
                    focusManager.clearFocus()
                    when {
                        password.isEmpty() || password.length < 6 -> {
                            Toast.makeText(
                                context,
                                context.getString(R.string.string_validverificationcode),
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        else -> verifyOTPPress(password.trim())
                    }
                },
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                ),
                colors = ButtonDefaults.buttonColors(contentColor = Chocolate500),

                ) {
                Text(
                    text = stringResource(id = R.string.string_verify),
//                modifier = Modifier.padding= 42.dp),
                    color = Color.White,
                    style = TextStyle(
                        letterSpacing = 2.sp,
                        fontSize = 22.scaledSp(),
                        fontFamily = FontFamily(
                            Font(R.font.proxima_nova_regular)
                        )
                    ),
                )
            }
        }

    }
}


fun pixelsToSp(context: Context, px: Float): Float {
    val scaledDensity: Float = context.getResources().getDisplayMetrics().scaledDensity
    return px / scaledDensity
}







