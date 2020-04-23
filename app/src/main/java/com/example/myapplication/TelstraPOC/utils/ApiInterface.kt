package com.example.myapplication.TelstraPOC.utils

import com.example.myapplication.TelstraPOC.countryFeatures.Model.ResponseModel
import retrofit2.http.GET
import rx.Observable
/*
Interface to call API
 */
interface ApiInterface  {
    // This API returns the Country features from server
    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getCountryFeatureList(): Observable<ResponseModel>
}