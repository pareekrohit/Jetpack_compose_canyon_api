package com.infobeans.canyonranchapp.screen.ui.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.screen.BackgroundScreen_Login_Otp
import com.infobeans.canyonranchapp.ui.theme.Chocolate500
import com.infobeans.canyonranchapp.ui.theme.FillColor
import com.infobeans.canyonranchapp.ui.theme.LightColor
import com.infobeans.canyonranchapp.ui.theme.SubtitleColor
import com.infobeans.canyonranchapp.utils.Helper
import com.infobeans.canyonranchapp.utils.MaskTransformation
import com.infobeans.canyonranchapp.utils.NumberDefaults.MASK
import com.infobeans.canyonranchapp.utils.scaledSp
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    loginPress: (textEmail: String, textPhonenumber: String) -> Unit,
//    registerPress: () -> Unit,
) {

    /* Scaffold(
         topBar = { TopBar() },
         bottomBar = { BottomNavigationBar() }
     ) {
         /* Add code later */
    }*/

    BackgroundScreen_Login_Otp {
        LoginScreenUI(
            loginPress = loginPress
        )
    }
}


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenUI(
    modifier: Modifier = Modifier,
    loginPress: (username: String, password: String) -> Unit,
//    registerPress: () -> Unit,
) {
    var textemail by rememberSaveable { mutableStateOf("") }
    var textphonenumber by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
//    val isValidate by derivedStateOf { viewModel.textemail.isNotBlank() && viewModel.textphonenumber.isNotBlank() }

    val coroutineScope = rememberCoroutineScope()
    /*var loadingProgressBar by rememberSaveable { mutableStateOf(value = false) }*/

    /*SetProgressLoader(viewModel)*/

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp)
            .padding(top = 58.dp)
    ) {
        Text(
            text = stringResource(id = R.string.string_letssignin),
            fontSize = 36.scaledSp(),
            fontWeight = FontWeight(400),
            fontFamily = FontFamily(
                Font(R.font.cormorant_garamond_regular)
            ),
            color = SubtitleColor,
            lineHeight = 32.scaledSp(),
            softWrap = true,
//            style = MaterialTheme.typography.h2
        )
        Text(
            text = stringResource(id = R.string.string_emailaddress),
            modifier = Modifier.padding(top = 42.dp),
            color = FillColor,
//            style = MaterialTheme.typography.body2
            style = TextStyle(
                letterSpacing = 2.sp,
                fontSize = 18.scaledSp(),
                fontFamily = FontFamily(
                    Font(R.font.proxima_nova_regular)
                )
            ),
        )


        /*TextField(
        modifier = Modifier.padding(top = 12.dp),
        value = text,
        onValueChange = {
            text = it
        },
//            label = { Text("Label") },

        colors = TextFieldDefaults.textFieldColors(
            textColor = SubtitleColor,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Chocolate500,
            unfocusedIndicatorColor = LightColor,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        placeholder = { Text(text = "Your email address", color = LightColor) },
        visualTransformation =
        VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
            autoCorrect = false
        ),

        textStyle = MaterialTheme.typography.body1
    )*/

        BasicTextField(
            modifier = Modifier.padding(top = (12.dp)),
            value = textemail,
            onValueChange = { textemail = it },
            decorationBox = { innerTextField ->

                Column(
                    modifier = Modifier
                ) {
                    if (textemail.isEmpty()) {
                        Text(
                            stringResource(id = R.string.string_youremailaddress),
                            color = LightColor,
                            fontFamily = FontFamily(Font(R.font.proxima_nova_regular)),
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.scaledSp()
                        )
                    } else
                        innerTextField()
                    Divider(
                        color = if (textemail.isEmpty()) LightColor else Chocolate500,
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) },
            ),
            singleLine = true,
            maxLines = 1,
        )

        Text(
            text = stringResource(id = R.string.string_phonenumber),
            modifier = Modifier.padding(top = 32.dp),
            color = FillColor,
//            style = MaterialTheme.typography.body2
            style = TextStyle(
                letterSpacing = 2.sp,
                fontSize = 18.scaledSp(),
                fontFamily = FontFamily(
                    Font(R.font.proxima_nova_regular)
                )
            ),
        )

        BasicTextField(
            modifier = Modifier.padding(top = (12.dp)),
            value = textphonenumber,
            onValueChange = {
                if (it.length <= 10)
                    textphonenumber = it
            },
            decorationBox = { innerTextField ->

                Column(
                    modifier = Modifier
                ) {
                    if (textphonenumber.isEmpty()) {
                        Text(
                            stringResource(id = R.string.string_yourphonenumber),
                            color = LightColor,
                            fontFamily = FontFamily(Font(R.font.proxima_nova_regular)),
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.scaledSp()
                        )
                    } else
                        innerTextField()
                    Divider(
                        color = if (textphonenumber.isEmpty()) LightColor else Chocolate500,
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done,
                autoCorrect = false
            ),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            singleLine = true,
            maxLines = 1,

            visualTransformation = MaskTransformation(MASK)
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 54.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                modifier = Modifier
                    .width(186.dp)
                    .height(51.dp),
//                enabled = isValidate,
                onClick = {
                    //your onclick code here

                    coroutineScope.launch {

                        keyboardController?.hide()
//                        if (!textemail.isNullOrEmpty() && Helper.isValidEmail(textemail)) {
//                            if (!textphonenumber.isNullOrEmpty()) {
//                                fetchData(application, viewModel, navController)
//                            } else {
//                                Toast.makeText(
//                                    context,
//                                    "Please enter phone number",
//                                    Toast.LENGTH_LONG
//                                )
//                                    .show()
//                            }
//                        } else {
//                            Toast.makeText(context, "Please enter email", Toast.LENGTH_LONG)
//                                .show()
//                        }


                        when {
                            !Helper.isValidEmail(textemail) -> {
                                Toast.makeText(
                                    context,
                                    context.getString(R.string.string_validemailaddress),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            textphonenumber.isEmpty() || textphonenumber.length < 10 -> {
                                Toast.makeText(
                                    context,
                                    context.getString(R.string.string_validphonenumber),
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                            else -> loginPress(textemail, textphonenumber)
                        }
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
                    text = stringResource(id = R.string.string_signin),
//                modifier = Modifier.padding(top = 42.dp),
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






