package com.example.myapplication.TelstraPOC.countryFeatures

import com.example.myapplication.TelstraPOC.utils.UseCase
import com.example.myapplication.TelstraPOC.executer.ExecuterThread
import com.example.myapplication.TelstraPOC.countryFeatures.Model.CountryFeatureRequestModel
import com.example.myapplication.TelstraPOC.countryFeatures.Model.ResponseModel
import com.example.myapplication.TelstraPOC.executer.UIThread
import rx.Observable
/*
Usecase for the ImageListActivity
 */
class CountryFeatureUseCase (executorThread : ExecuterThread, postExecuterThread: UIThread)
    : UseCase<ResponseModel>(executorThread,postExecuterThread) {
    var request: CountryFeatureRequestModel? = null

    override fun createObservable(): Observable<ResponseModel> {
        return request!!.getApi()!!.getCountryFeatureList()
    }
}
