package com.infobeans.canyonranchapp.screen.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.base.BaseFragment
import com.infobeans.canyonranchapp.screen.ui.components.ProgressScreen
import com.infobeans.canyonranchapp.utils.GetStatusBar
import com.infobeans.canyonranchapp.utils.ViewState
import com.infobeans.canyonranchapp.utils.networkconnectivity.ConnectionState
import com.infobeans.canyonranchapp.utils.networkconnectivity.connectivityState
import com.infobeans.canyonranchapp.viewmodel.AuthViewModel


class LoginFragment : BaseFragment() {
    private val viewModel: AuthViewModel by viewModels()
    var bundle = Bundle()

    @Composable
    override fun SetContent() {

        GetStatusBar(
            systemBarColorId = R.color.white,
            systemBarDarkIcon = true,
            navigationBarColorId = R.color.white,
            navigationBarDarkIcon = true
        )
// TODO: to hide statusbar and make our UI start from top use below code
        /*val decorView: View = requireActivity().getWindow().getDecorView()
        decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        )*/
        val connection by connectivityState()
        val isConnected = connection === ConnectionState.Available

        LoginScreen(

//            registerPress = {
//            val dest = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
//            findNavController().navigate(dest)
//        },
            loginPress = { textEmail, textPhonenumber ->
                bundle = bundleOf(
                    Pair("email", textEmail.toString().trim()),
                    Pair("phone", textPhonenumber.toString().trim())
                )
                viewModel.performLogin(textEmail, textPhonenumber)

//                Toast.makeText(
//                    context,
//                    "$textEmail \n $textPhonenumber",
//                    Toast.LENGTH_LONG
//                ).show()
            })


        val dialogShow = remember { mutableStateOf(false) }
        val titleDialog = remember { mutableStateOf("") }
        val messageDialog = remember { mutableStateOf("") }

        val loginState = viewModel.loginState.collectAsState().value
        when (loginState) {
            is ViewState.Loading -> ProgressScreen()
            is ViewState.Success -> {
                if (loginState.data.success == true) {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToOtpFragment(
                            bundle.getString("email").toString(),
                            bundle.getString("phone").toString()
                        )
                    )
                    //TODO: add below line to make viewmodel IDLE so that when we press back from
                    // OTP to Login it will not recompose
                    viewModel._loginState.tryEmit(ViewState.Idle)
                } else {
                    dialogShow.value = true
                    titleDialog.value = "Login"
                    messageDialog.value = loginState.data.message!!
                }
            }
            is ViewState.Error -> {
                dialogShow.value = true
                titleDialog.value = "Login"
                messageDialog.value = (loginState as ViewState.Error).errorCode?.message!!
            }
        }

        OpenDialog(
            isShow = dialogShow.value,
            title = titleDialog.value,
            message = messageDialog.value
        ) {
            dialogShow.value = false
            viewModel._loginState.tryEmit(ViewState.Idle)
        }
    }


}

