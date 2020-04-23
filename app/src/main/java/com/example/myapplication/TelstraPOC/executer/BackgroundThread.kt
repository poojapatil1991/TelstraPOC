package com.example.myapplication.TelstraPOC.executer

import rx.Scheduler
import rx.schedulers.Schedulers
/*
Creates background thread
 */
class BackgroundThread : ExecuterThread {
    override fun getScheduler(): Scheduler? {
        return Schedulers.newThread()
    }
}