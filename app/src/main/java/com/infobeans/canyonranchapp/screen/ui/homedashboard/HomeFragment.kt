package com.infobeans.canyonranchapp.screen.ui.homedashboard

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.fragment.app.viewModels
import com.infobeans.canyonranchapp.R
import com.infobeans.canyonranchapp.base.BaseFragment
import com.infobeans.canyonranchapp.network.SharedPreferenceData
import com.infobeans.canyonranchapp.network.dto.ResponseDto
import com.infobeans.canyonranchapp.screen.navGraph.DashboardScreen
import com.infobeans.canyonranchapp.screen.ui.components.ProgressScreen
import com.infobeans.canyonranchapp.utils.GetStatusBar
import com.infobeans.canyonranchapp.utils.ViewState
import com.infobeans.canyonranchapp.viewmodel.DashboardViewModel
import com.skydoves.sandwich.ResponseDataSource


class HomeFragment : BaseFragment() {

    private val viewModel: DashboardViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dashboardProfile()
    }


    @Composable
    override fun SetContent() {

        when (viewModel.currentTab.collectAsState().value) {

            DashboardViewModel.BottomBarTab.HOME -> {
                Log.d("nav route", "Home")
                val decorView: View = requireActivity().getWindow().getDecorView()
                decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )

                /*GetStatusBar(
                    systemBarColorId = R.color.white,
                    systemBarDarkIcon = true,
                    navigationBarColorId = R.color.white,
                    navigationBarDarkIcon = true
                )*/
            }

            else -> {
                val decorView: View = requireActivity().getWindow().getDecorView()
                decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                )

                /*GetStatusBar(
                    systemBarColorId = R.color.choclate_500,
                    systemBarDarkIcon = false,
                    navigationBarColorId = R.color.white,
                    navigationBarDarkIcon = true
                )*/
            }

        }


        /*GetStatusBar(
            systemBarColorId = R.color.white,
            systemBarDarkIcon = true,
            navigationBarColorId = R.color.white,
            navigationBarDarkIcon = true
        )*/


        DashboardScreen(viewModel = viewModel)


        val dialogShow = remember { mutableStateOf(false) }
        val titleDialog = remember { mutableStateOf("") }
        val messageDialog = remember { mutableStateOf("") }

        val dashboardState = viewModel.dashboardState.collectAsState().value
        when (dashboardState) {
            is ViewState.Loading -> ProgressScreen()
            is ViewState.Success -> {
                if (dashboardState.data.success == true) {
                    /*findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToOtpFragment(
                            bundle.getString("email").toString(),
                            bundle.getString("phone").toString()
                        )
                    )*/

                    val res: ResponseDto = dashboardState.data
                    val sharedPrefData: ResponseDto? = SharedPreferenceData.getLoggedUser()

                    if (sharedPrefData != null) {
                        sharedPrefData.email = SharedPreferenceData.getLoggedUser()?.email
                        sharedPrefData.phone = SharedPreferenceData.getLoggedUser()?.phone
                        sharedPrefData.data?.token =
                            SharedPreferenceData.getLoggedUser()?.data?.token

                        sharedPrefData.data?.firstName = res.data?.firstName
                        sharedPrefData.data?.lastName = res.data?.lastName
                        sharedPrefData.data?.fullName = res.data?.fullName
                        sharedPrefData.data?.birthday = res.data?.birthday
                        sharedPrefData.data?.type = res.data?.type
                        sharedPrefData.data?.locationID = res.data?.locationID
                        sharedPrefData.data?.locationName = res.data?.locationName
                        sharedPrefData.data?.tripStartDate = res.data?.tripStartDate
                        sharedPrefData.data?.tripEndDate = res.data?.tripEndDate

                        SharedPreferenceData.saveLoggedUSer(sharedPrefData)
                    }


                    Log.d("HomeFragment Response", "${dashboardState.data.data?.fullName}")
                    //TODO: add below line to make viewmodel IDLE so that when we press back from
                    // OTP to Login it will not recompose
                    viewModel._dashboardState.tryEmit(ViewState.Idle)
                } else {
                    dialogShow.value = true
                    titleDialog.value = "Login"
                    messageDialog.value = dashboardState.data.message!!
                }
            }
            is ViewState.Error -> {
                dialogShow.value = true
                titleDialog.value = "Login"
                messageDialog.value = (dashboardState as ViewState.Error).errorCode?.message!!
            }
        }

        OpenDialog(
            isShow = dialogShow.value,
            title = titleDialog.value,
            message = messageDialog.value
        ) {
            dialogShow.value = false
            viewModel._dashboardState.tryEmit(ViewState.Idle)
        }

    }


}

