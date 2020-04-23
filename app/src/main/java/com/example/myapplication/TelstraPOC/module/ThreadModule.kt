package com.example.myapplication.TelstraPOC.module

import com.example.myapplication.TelstraPOC.executer.BackgroundThread
import com.example.myapplication.TelstraPOC.executer.ExecuterThread
import com.example.myapplication.TelstraPOC.executer.UIThread
/*
Thread module to give the UI and background threads
 */
class ThreadModule {

    //Function returns the background thread
    fun provideExecutorThread(): ExecuterThread {
        return BackgroundThread()
    }

    // Function returns the UI thread
    fun providePostExecutionThread(): UIThread {
        return UIThread()
    }
}
