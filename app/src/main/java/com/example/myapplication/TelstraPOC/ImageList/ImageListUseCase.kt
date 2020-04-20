package com.example.myapplication.TelstraPOC.ImageList

import com.example.myapplication.TelstraPOC.Commen.UseCase
import com.example.myapplication.TelstraPOC.Executer.ExecuterThread
import com.example.myapplication.TelstraPOC.Executer.PostExecuterThread
import com.example.myapplication.TelstraPOC.ImageList.Model.ImageListRequestModel
import com.example.myapplication.TelstraPOC.ImageList.Model.ResponseModel
import rx.Observable
/*
Usecase for the ImageListActivity
 */
class ImageListUseCase (executorThread : ExecuterThread, postExecuterThread: PostExecuterThread ,requestModel: ImageListRequestModel)
    : UseCase<ResponseModel>(executorThread,postExecuterThread) {
    var request: ImageListRequestModel? = null

    override fun createObservable(): Observable<ResponseModel> {
        return request!!.getApi()!!.getImageInfoListRequest()
    }
}
