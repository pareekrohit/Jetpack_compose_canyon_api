package com.infobeans.canyonranchapp

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        myAppContext = this
        /*AppDB.getDatabase(this)*/

    }

    /*val database: AppDB by lazy { AppDB.getDatabase(this) }*/

    companion object {
        lateinit var myAppContext: MyApplication
    }


}