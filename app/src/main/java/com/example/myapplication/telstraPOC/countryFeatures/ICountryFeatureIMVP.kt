package com.example.myapplication.telstraPOC.countryFeatures

import com.example.myapplication.telstraPOC.utils.IMVP
import com.example.myapplication.telstraPOC.countryFeatures.model.ResponseModel
/*
Base MVP structure for the ImageListActivity
 */
interface ICountryFeatureIMVP : IMVP {

    interface Model : IMVP.Model

    interface View : IMVP.View {
        fun showError(message: String?)
        fun showCountryFeatureList(
            responseModel: ResponseModel?
        )
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : IMVP.Presenter<View> {
        fun onStart()
        fun onStop()
        fun loadCountryFeatureList()
    }
}
