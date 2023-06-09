package com.infobeans.canyonranchapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.infobeans.canyonranchapp.base.composeView
import com.infobeans.canyonranchapp.ui.theme.CanyonRanchAppTheme

abstract class BaseFragmentLifeCycle: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        lifeCycleEvent()
        CanyonRanchAppTheme() {
            setContent()
        }
    }

    @Composable
    abstract fun setContent(): Unit

    @Composable
    fun lifeCycleEvent() {
        val lifeCycleState = LocalLifecycleOwner.current.lifecycle.observeAsSate()
        val state = lifeCycleState.value
        when(state) {
            Lifecycle.Event.ON_RESUME -> {
            }
            Lifecycle.Event.ON_START -> {
            }
            else -> {}
        }
    }


    @Composable
    fun Lifecycle.observeAsSate(): State<Lifecycle.Event> {
        val state = remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
        DisposableEffect(this) {
            val observer = LifecycleEventObserver { _, event ->
                state.value = event
            }
            this@observeAsSate.addObserver(observer)
            onDispose {
                this@observeAsSate.removeObserver(observer)
            }
        }
        return state
    }
}