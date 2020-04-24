package com.example.myapplication.telstraPOC.countryFeatures.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.telstraPOC.utils.CountryFeatureApplication
import com.example.myapplication.telstraPOC.utils.GlideImageDownloader
import com.example.myapplication.telstraPOC.countryFeatures.model.CountryFeature
/*
Adapter to show the list of images from server
 */
class CountryFeatureAdapter (val mCountryFeatureList : ArrayList<CountryFeature>) : RecyclerView.Adapter<CountryFeatureAdapter.ViewHolder>() {

    // glideImageDownloader to download images from server
    lateinit var glideImageDownloader: GlideImageDownloader

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.main_card_view, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        glideImageDownloader = GlideImageDownloader()
        val mGeneralInfoObj: CountryFeature = mCountryFeatureList[position]
        viewHolder.mTvTitle?.text = mGeneralInfoObj.title
        viewHolder.mTvDescription?.text = mGeneralInfoObj.description
        glideImageDownloader.downloadImage(CountryFeatureApplication.context,mGeneralInfoObj.imageHref,viewHolder.mIvPhoto)

    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return mCountryFeatureList.size
    }
    // View holder representing single row in list
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val mTvTitle = itemView.findViewById(R.id.tv_title) as? TextView
        val mTvDescription = itemView.findViewById(R.id.tv_description) as? TextView
        val mIvPhoto = itemView.findViewById(R.id.iv_photo) as ImageView
    }
}
