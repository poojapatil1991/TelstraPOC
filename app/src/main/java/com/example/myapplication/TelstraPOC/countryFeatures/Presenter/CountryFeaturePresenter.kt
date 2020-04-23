package com.example.myapplication.TelstraPOC.countryFeatures.Presenter

import com.example.myapplication.TelstraPOC.utils.BasePresenter
import com.example.myapplication.TelstraPOC.countryFeatures.CountryFeatureMVP
import com.example.myapplication.TelstraPOC.countryFeatures.CountryFeatureUseCase
import com.example.myapplication.TelstraPOC.countryFeatures.Model.ResponseModel
import rx.Subscriber
/*
Presenter to communicate between ImageListActivity and ResponseModel
uses imageListUseCase to download data from API
 */
class CountryFeaturePresenter (val countryFeatureUseCase: CountryFeatureUseCase): BasePresenter<CountryFeatureMVP.View>() , CountryFeatureMVP.Presenter{

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
