package com.example.myapplication.TelstraPOC.Executer

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
/*
UI thread
 */
class UIThread  : PostExecuterThread {
    override fun getScheduler(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }
}
