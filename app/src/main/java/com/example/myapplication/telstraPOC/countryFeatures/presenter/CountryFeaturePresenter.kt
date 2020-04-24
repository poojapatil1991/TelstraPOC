package com.example.myapplication.telstraPOC.countryFeatures.presenter

import com.example.myapplication.telstraPOC.utils.BasePresenter
import com.example.myapplication.telstraPOC.countryFeatures.ICountryFeatureIMVP
import com.example.myapplication.telstraPOC.countryFeatures.CountryFeatureUseCase
import com.example.myapplication.telstraPOC.countryFeatures.model.ResponseModel
import rx.Subscriber
/*
Presenter to communicate between ImageListActivity and ResponseModel
uses imageListUseCase to download data from API
 */
class CountryFeaturePresenter (val countryFeatureUseCase: CountryFeatureUseCase): BasePresenter<ICountryFeatureIMVP.View>() , ICountryFeatureIMVP.Presenter{

    override fun onStart() {}
    override fun onStop() {}
    override fun onViewAttached() {}
    /*
    function to download image data from server
     */
    override fun loadCountryFeatureList() {
        view()!!.showLoading()
        countryFeatureUseCase!!.execute( CountryFeatureSubscriber())
    }
    /*
    Subscriber to show image list on UI
    as soon as image list downloads from server it get notifies and show list of images on UI
     */
    inner class CountryFeatureSubscriber : Subscriber<ResponseModel>() {
        override fun onCompleted() {}
        override fun onError(e: Throwable) {
            view()!!.showError("Please check the internet Connection, and try after some time")
        }
        override fun onNext(resDetails: ResponseModel) {
            view()!!.hideLoading()
            view()!!.showCountryFeatureList( resDetails)
        }
    }
}
