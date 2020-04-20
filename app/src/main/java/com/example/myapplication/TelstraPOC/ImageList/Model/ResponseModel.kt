package com.example.myapplication.TelstraPOC.ImageList.Model
/*
Model for API response
 */
data class ResponseModel (
    val title: String,
    val rows: ArrayList<ImageDetails>
)