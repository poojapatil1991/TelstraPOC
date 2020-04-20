package com.example.myapplication.TelstraPOC.Commen

import rx.Observable
import rx.Subscriber
/*
Interacter to interact between View and Presenter
Used the Publisher and subscriber model of rxAndroid.
 */
interface Interactor <T> {

    fun execute(subscriber : Subscriber<T>);
    fun execute(): Observable<T>

}