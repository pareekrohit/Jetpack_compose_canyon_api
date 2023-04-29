package com.infobeans.canyonranchapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import com.infobeans.canyonranchapp.ui.theme.CanyonRanchAppTheme
import yodeput.mobile.banking.feature.ui.component.DialogMessage

abstract class BaseFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {

        CanyonRanchAppTheme {
            SetContent()
        }
    }

    @Composable
    abstract fun SetContent(): Unit

    @Composable
    open fun OpenDialog(isShow: Boolean, title:String, message: String, onDismiss: () -> Unit){
        if(isShow) {
            DialogMessage(
                title = title,
                message = message,
                onDismiss = {
                    onDismiss()
                })
        }
    }

    @Composable
    open fun showToast(message: String, duration: Int ){
        Toast.makeText(
            context,
            message,
            duration
        ).show()
    }
}