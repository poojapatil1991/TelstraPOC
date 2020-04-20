package com.example.myapplication.TelstraPOC.Commen

import com.example.myapplication.TelstraPOC.ImageList.Model.ResponseModel
import retrofit2.http.GET
import rx.Observable
/*
Interface to call API
 */
interface IApiInterface  {
    // This API returns the image list from server
    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getImageInfoListRequest(): Observable<ResponseModel>
}