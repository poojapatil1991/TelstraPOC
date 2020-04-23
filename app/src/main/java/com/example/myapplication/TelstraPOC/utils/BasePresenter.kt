package com.example.myapplication.TelstraPOC.utils
/*
Its is the Base Presenter
Its abstract class, default implementation of methods is defined here.
 */
abstract class BasePresenter <V : MVP.View> : MVP.Presenter<V> {

    private  var mMvpView : V? = null

    protected abstract fun onViewAttached()

    protected fun onViewDetached() {}
    /*
    This method returns the mpv view attached to the presenter
     */
     fun view() : V? {
        return mMvpView
    }
    /*
    This method gets called as soon as view attaches to presenter
     */
    override fun onAttachView(view : V) {
        mMvpView = view;
        onViewAttached();
    }
    /*
    This method gets called as soon as view detached from presenter
    */
    override fun onDettachView() {
        mMvpView = null;
        onViewDetached();
    }
}
