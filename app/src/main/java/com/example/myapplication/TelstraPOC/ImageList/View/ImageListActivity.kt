package com.example.myapplication.TelstraPOC.ImageList.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

import kotlinx.android.synthetic.main.activity_image_list.*
/*
Launcher activity
It contains First2Fragment
 */
class ImageListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_list)
        setSupportActionBar(toolbar)
    }
    fun setToolbarTitle(title:String){
        supportActionBar!!.title = title
    }
}
