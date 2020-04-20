package com.example.myapplication.TelstraPOC.Executer

import rx.Scheduler
/*
Base thread for Post execution
 */

interface PostExecuterThread {
    fun getScheduler(): Scheduler?
}