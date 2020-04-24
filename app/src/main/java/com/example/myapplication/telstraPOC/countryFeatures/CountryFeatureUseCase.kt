package com.example.myapplication.telstraPOC.countryFeatures

import com.example.myapplication.telstraPOC.utils.UseCase
import com.example.myapplication.telstraPOC.executer.IExecuterThread
import com.example.myapplication.telstraPOC.countryFeatures.model.CountryFeatureRequestModel
import com.example.myapplication.telstraPOC.countryFeatures.model.ResponseModel
import com.example.myapplication.telstraPOC.executer.UIThread
import rx.Observable
/*
Usecase for the ImageListActivity
 */
class CountryFeatureUseCase (executorThreadI : IExecuterThread, postExecuterThread: UIThread)
    : UseCase<ResponseModel>(executorThreadI,postExecuterThread) {
    var request: CountryFeatureRequestModel? = null

    override fun createObservable(): Observable<ResponseModel> {
        return request!!.getApi()!!.getCountryFeatureList()
    }
}
