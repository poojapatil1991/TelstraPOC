package com.example.myapplication.TelstraPOC.Commen

import com.example.myapplication.TelstraPOC.Executer.ExecuterThread
import com.example.myapplication.TelstraPOC.Executer.PostExecuterThread
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.subscriptions.Subscriptions
/*
Base usecase to interact between Presenter an view
uses two seperate threads for backround work and main thread work
 */
abstract class UseCase <T>( executorThread : ExecuterThread, postExecutionThread : PostExecuterThread) : Interactor<T> {
    private var  executorThread : ExecuterThread? = null
    private var  postExecutionThread : PostExecuterThread? = null
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
    subscribe on executorThread(backround) thread
    observes on postExecutionThread (main) thread
     */
    override fun execute( subscriber : Subscriber<T>) {
        this.subscription = createObservable()
            .subscribeOn(executorThread!!.getScheduler())
            .observeOn(postExecutionThread!!.getScheduler())
            .subscribe(subscriber);
    }

    override fun execute():Observable<T> {
        return createObservable();
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
