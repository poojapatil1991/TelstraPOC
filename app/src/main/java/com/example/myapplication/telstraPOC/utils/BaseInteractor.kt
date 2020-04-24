package com.example.myapplication.telstraPOC.utils

import rx.Subscriber
/*
This is base Interacter to interact between View and Presenter
Its implementation is give in the UseCase class
Used the Publisher and subscriber model of rxAndroid.
 */
interface BaseInteractor <T> {
    fun execute(subscriber : Subscriber<T>);
}