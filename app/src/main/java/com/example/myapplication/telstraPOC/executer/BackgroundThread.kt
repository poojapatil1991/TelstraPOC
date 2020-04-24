package com.example.myapplication.telstraPOC.executer

import rx.Scheduler
import rx.schedulers.Schedulers
/*
Creates background thread
 */
class BackgroundThread : IExecuterThread {
    override fun getScheduler(): Scheduler? {
        return Schedulers.newThread()
    }
}