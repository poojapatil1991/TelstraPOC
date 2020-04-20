package com.example.myapplication.TelstraPOC.ImageList.Model
/*
Model for image details
describes the row from API response
 */
data class ImageDetails (
    var title: String = "",
    var description: String = "",
    var imageHref : String = ""
)