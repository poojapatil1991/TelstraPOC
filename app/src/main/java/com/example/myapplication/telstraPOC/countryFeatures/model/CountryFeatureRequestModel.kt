package com.example.myapplication.telstraPOC.countryFeatures.model

import com.example.myapplication.telstraPOC.utils.ApiInterface
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
