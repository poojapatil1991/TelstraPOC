package com.example.myapplication.TelstraPOC.countryFeatures.Model
/*
Model for API response
 */
data class ResponseModel (
    val title: String,
    val rows: ArrayList<CountryFeature>
)