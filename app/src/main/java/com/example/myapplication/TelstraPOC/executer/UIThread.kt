package com.example.myapplication.TelstraPOC.executer

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
/*
UI thread
 */
class UIThread  : ExecuterThread {
    override fun getScheduler(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }
}
