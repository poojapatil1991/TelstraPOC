package com.example.myapplication.TelstraPOC.ImageList.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.TelstraPOC.Commen.AppContext
import com.example.myapplication.TelstraPOC.Commen.GlideImageDownloader
import com.example.myapplication.TelstraPOC.ImageList.Model.ImageDetails
/*
Adapter to show the list of images from server
 */
class ImageListAdapter (val mGenenralInfoList : ArrayList<ImageDetails>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    // glideImageDownloader to download images from server
    lateinit var glideImageDownloader: GlideImageDownloader

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.main_card_view, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        glideImageDownloader = GlideImageDownloader()
        val mGeneralInfoObj: ImageDetails = mGenenralInfoList[position]
        viewHolder.mTvTitle?.text = mGeneralInfoObj.title
        viewHolder.mTvDescription?.text = mGeneralInfoObj.description
        glideImageDownloader.downloadImage(AppContext.context,mGeneralInfoObj.imageHref,viewHolder.mIvPhoto)

    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return mGenenralInfoList.size
    }
    // View holder representing single row in list
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val mTvTitle = itemView.findViewById(R.id.tv_title) as? TextView
        val mTvDescription = itemView.findViewById(R.id.tv_description) as? TextView
        val mIvPhoto = itemView.findViewById(R.id.iv_photo) as ImageView
    }
}
