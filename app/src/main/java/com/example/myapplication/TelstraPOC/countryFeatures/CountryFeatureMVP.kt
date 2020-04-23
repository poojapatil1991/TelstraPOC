package com.example.myapplication.TelstraPOC.countryFeatures

import com.example.myapplication.TelstraPOC.utils.MVP
import com.example.myapplication.TelstraPOC.countryFeatures.Model.ResponseModel
/*
Base MVP structure for the ImageListActivity
 */
interface CountryFeatureMVP : MVP {

    interface Model : MVP.Model

    interface View : MVP.View {
        fun showError(message: String?)
        fun showCountryFeatureList(
            responseModel: ResponseModel?
        )
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : MVP.Presenter<View> {
        fun onStart()
        fun onStop()
        fun loadCountryFeatureList()
    }
}
