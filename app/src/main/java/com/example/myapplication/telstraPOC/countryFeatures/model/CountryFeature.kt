package com.example.myapplication.telstraPOC.countryFeatures.model
/*
Model for image details
describes the row from API response
 */
data class CountryFeature (
    var title: String = "",
    var description: String = "",
    var imageHref : String = ""
)