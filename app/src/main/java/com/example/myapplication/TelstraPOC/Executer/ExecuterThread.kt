package com.example.myapplication.TelstraPOC.Executer

import rx.Scheduler
/*
Base thread for execution
 */
interface ExecuterThread {
    fun getScheduler(): Scheduler?
}