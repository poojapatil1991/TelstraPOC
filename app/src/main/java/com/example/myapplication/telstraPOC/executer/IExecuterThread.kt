package com.example.myapplication.telstraPOC.executer

import rx.Scheduler
/*
Base thread for execution
 */
interface IExecuterThread {
    fun getScheduler(): Scheduler?
}