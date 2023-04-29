package com.infobeans.canyonranchapp.utils.networkconnectivity

sealed class ConnectionState{
    object Available : ConnectionState()
    object Unavailable : ConnectionState()
}
