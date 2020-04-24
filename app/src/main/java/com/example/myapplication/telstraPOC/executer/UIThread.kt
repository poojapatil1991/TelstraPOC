package com.example.myapplication.telstraPOC.executer

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
/*
UI thread
 */
class UIThread  : IExecuterThread {
    override fun getScheduler(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }
}
