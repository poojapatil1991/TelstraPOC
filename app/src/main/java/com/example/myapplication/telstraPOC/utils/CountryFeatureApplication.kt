package com.example.myapplication.telstraPOC.utils

import android.app.Application
import android.content.Context
/*
This class gives the context of whole application
 */
class CountryFeatureApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
    companion object {
            lateinit var context: Context
    }
}
