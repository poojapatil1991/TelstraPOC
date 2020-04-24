package com.example.myapplication.telstraPOC.countryFeatures.model
/*
Model for API response
 */
data class ResponseModel (
    val title: String,
    val rows: ArrayList<CountryFeature>
)