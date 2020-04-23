package com.example.myapplication.TelstraPOC.countryFeatures.Model

import com.example.myapplication.TelstraPOC.utils.ApiInterface
/*
Model to call the API
 */
class CountryFeatureRequestModel {
    private var api: ApiInterface? = null

    fun getApi(): ApiInterface? {
        return api
    }

    fun setApi(api: ApiInterface?) {
        this.api = api
    }
}
