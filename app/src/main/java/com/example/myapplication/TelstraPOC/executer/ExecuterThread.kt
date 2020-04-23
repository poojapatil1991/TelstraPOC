package com.example.myapplication.TelstraPOC.executer

import rx.Scheduler
/*
Base thread for execution
 */
interface ExecuterThread {
    fun getScheduler(): Scheduler?
}