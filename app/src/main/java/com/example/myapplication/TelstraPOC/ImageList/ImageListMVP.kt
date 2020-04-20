package com.example.myapplication.TelstraPOC.ImageList

import com.example.myapplication.TelstraPOC.Commen.MVP
import com.example.myapplication.TelstraPOC.ImageList.Model.ResponseModel
/*
Base MVP structure for the ImageListActivity
 */
interface ImageListMVP : MVP {

    interface Model : MVP.Model

    interface View : MVP.View {
        fun showError(message: String?)
        fun showImageList(
            reaponseModel: ResponseModel?
        )
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : MVP.Presenter<View> {
        fun onStart()
        fun onStop()
        fun loadMovieList()
    }
}
