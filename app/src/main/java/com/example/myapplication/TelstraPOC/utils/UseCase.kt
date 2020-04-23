package com.example.myapplication.TelstraPOC.utils

import com.example.myapplication.TelstraPOC.executer.ExecuterThread
import com.example.myapplication.TelstraPOC.executer.UIThread
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.subscriptions.Subscriptions
/*
Base usecase to interact between Presenter an view
uses two separate threads for background work and main thread work
 */
abstract class UseCase <T>( executorThread : ExecuterThread, postExecutionThread : UIThread) : BaseInteractor<T> {
    private var  executorThread : ExecuterThread? = null
    private var  postExecutionThread : UIThread? = null
    private var subscription : Subscription? = Subscriptions.empty()

    init  {
        this.executorThread = executorThread;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    abstract fun createObservable() : Observable<T>;
    /*
    API call
    subscribe on executorThread(background) thread
    observes on postExecutionThread (main) thread
     */
    override fun execute( subscriber : Subscriber<T>) {
        this.subscription = createObservable()
            .subscribeOn(executorThread!!.getScheduler())
            .observeOn(postExecutionThread!!.getScheduler())
            .subscribe(subscriber);
    }

    /**
     * Unsubscribes from current {@link Subscription}.
     */
    fun unsubscribe() {
        if (!subscription!!.isUnsubscribed()) {
            subscription!!.unsubscribe();
        }
    }
}
