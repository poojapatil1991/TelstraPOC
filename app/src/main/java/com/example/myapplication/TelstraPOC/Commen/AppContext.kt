package com.example.myapplication.TelstraPOC.Commen

import android.app.Application
import android.content.Context
/*
This class gives the context of whole application
 */
class AppContext : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
    companion object {
            lateinit var context: Context
    }
}
