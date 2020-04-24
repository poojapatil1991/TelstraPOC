package com.example.myapplication.telstraPOC.module

import com.example.myapplication.telstraPOC.executer.BackgroundThread
import com.example.myapplication.telstraPOC.executer.IExecuterThread
import com.example.myapplication.telstraPOC.executer.UIThread
/*
Thread module to give the UI and background threads
 */
class ThreadModule {

    //Function returns the background thread
    fun provideExecutorThread(): IExecuterThread {
        return BackgroundThread()
    }

    // Function returns the UI thread
    fun providePostExecutionThread(): UIThread {
        return UIThread()
    }
}
