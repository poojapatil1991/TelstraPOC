package com.example.myapplication.TelstraPOC.Executer

import rx.Scheduler
import rx.schedulers.Schedulers
/*
Creates backround thread
 */
class BackroundThread : ExecuterThread {
    override fun getScheduler(): Scheduler? {
        return Schedulers.newThread()
    }
}