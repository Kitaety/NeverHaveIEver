package com.example.testapp;

import android.app.Application
import com.droidnet.DroidNet


public class App() : Application() {
    override fun onCreate() {
        super.onCreate()
        //register DroidNet
        DroidNet.init(this.applicationContext)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        DroidNet.getInstance().removeAllInternetConnectivityChangeListeners()
    }
}
