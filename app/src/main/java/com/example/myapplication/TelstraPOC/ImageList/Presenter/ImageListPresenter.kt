package com.example.myapplication.TelstraPOC.ImageList.Presenter

import android.util.Log
import com.example.myapplication.TelstraPOC.Commen.BasePresenter
import com.example.myapplication.TelstraPOC.ImageList.ImageListMVP
import com.example.myapplication.TelstraPOC.ImageList.ImageListUseCase
import com.example.myapplication.TelstraPOC.ImageList.Model.ResponseModel
import rx.Subscriber
/*
Presenter to communicate between ImageListActivity and ResponseModel
uses imageListUseCase to download data from API
 */
class ImageListPresenter (val imageListUseCase: ImageListUseCase): BasePresenter<ImageListMVP.View>() , ImageListMVP.Presenter{

    override fun onStart() {}
    override fun onStop() {}
    override fun onViewAttached() {}
    /*
    function to download image data from server
     */
    override fun loadMovieList() {
        view()!!.showLoading()
        imageListUseCase!!.execute( MovieListSubscriber())
    }
    /*
    Subscriber to show image list on UI
    as soon as image list downloads from server it get notifies and show list of images on UI
     */
    inner class MovieListSubscriber : Subscriber<ResponseModel>() {
        override fun onCompleted() {}
        override fun onError(e: Throwable) {}
        override fun onNext(resDetails: ResponseModel) {
            view()!!.hideLoading()
            Log.d("Log123456788", resDetails.title)
            view()!!.showImageList( resDetails)
        }
    }

}
