package com.example.myapplication.TelstraPOC.ImageList.Model

import com.example.myapplication.TelstraPOC.Commen.IApiInterface
/*
Model to call the API
 */
class ImageListRequestModel {
    private var api: IApiInterface? = null

    fun getApi(): IApiInterface? {
        return api
    }

    fun setApi(api: IApiInterface?) {
        this.api = api
    }
}
