package com.example.myapplication.TelstraPOC.countryFeatures.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

import kotlinx.android.synthetic.main.activity_country_feature.*
/*
Launcher activity
It contains First2Fragment
 */
class CountryFeatureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_feature)
        setSupportActionBar(toolbar)
    }
    fun setToolbarTitle(title:String){
        supportActionBar!!.title = title
    }
}
