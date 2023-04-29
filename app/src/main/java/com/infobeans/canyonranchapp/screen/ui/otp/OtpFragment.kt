package com.infobeans.canyonranchapp.screen.ui.otp

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.fragment.app.viewModels
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.base.BaseFragment
import com.infobeans.canyonranchapp.network.SharedPreferenceData
import com.infobeans.canyonranchapp.network.dto.ResponseDto
import com.infobeans.canyonranchapp.screen.OtpScreen
import com.infobeans.canyonranchapp.screen.ui.components.ProgressScreen
import com.infobeans.canyonranchapp.utils.GetStatusBar
import com.infobeans.canyonranchapp.utils.ViewState
import com.infobeans.canyonranchapp.viewmodel.AuthViewModel
import androidx.navigation.fragment.findNavController

class OtpFragment : BaseFragment() {

    private val viewModel: AuthViewModel by viewModels()
    var email = ""
    var phone = ""

    @Composable
    override fun SetContent() {
        GetStatusBar(
            systemBarColorId = R.color.white,
            systemBarDarkIcon = true,
            navigationBarColorId = R.color.white,
            navigationBarDarkIcon = true
        )

        OtpScreen { textOTP ->
            viewModel.performOTP(email, phone, textOTP)
        }


        val dialogShow = remember { mutableStateOf(false) }
        val titleDialog = remember { mutableStateOf("") }
        val messageDialog = remember { mutableStateOf("") }

        val authState = viewModel.loginState.collectAsState().value
        when (authState) {
            is ViewState.Loading -> ProgressScreen()
            is ViewState.Success -> {
                if (authState.data.success == true) {

                    val res: ResponseDto = authState.data
                    res.email = email
                    res.phone = phone

                    SharedPreferenceData.saveLoggedUSer(res)
                    Log.d(
                        "OTPScreen",
                        "${SharedPreferenceData.getLoggedUser()?.data?.token} ${SharedPreferenceData.getLoggedUser()?.email}"
                    )

                    findNavController().navigate(OtpFragmentDirections.actionOtpFragmentToHomeFragment())


                } else {
                    dialogShow.value = true
                    titleDialog.value = "Login"
                    messageDialog.value = authState.data.message!!
                }
            }
            is ViewState.Error -> {
                dialogShow.value = true
                titleDialog.value = "OTP"
                messageDialog.value = (authState as ViewState.Error).errorCode?.message!!
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        email = requireArguments().getString("email").toString()
        phone = requireArguments().getString("phone").toString()
    }
}