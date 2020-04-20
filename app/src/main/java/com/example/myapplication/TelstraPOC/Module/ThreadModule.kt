package com.example.myapplication.TelstraPOC.Module

import com.example.myapplication.TelstraPOC.Executer.BackroundThread
import com.example.myapplication.TelstraPOC.Executer.ExecuterThread
import com.example.myapplication.TelstraPOC.Executer.PostExecuterThread
import com.example.myapplication.TelstraPOC.Executer.UIThread
/*
Thread module to give the UI and backround threads
 */
class ThreadModule {

    //Function returns the backround thread
    fun provideExecutorThread(): ExecuterThread {
        return BackroundThread()
    }

    // Funtion returns the UI thread
    fun providePostExecutionThread(): PostExecuterThread {
        return UIThread()
    }
}
