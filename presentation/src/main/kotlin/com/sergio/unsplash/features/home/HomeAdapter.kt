package com.sergio.unsplash.features.home

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sergio.unsplash.R
import com.sergio.unsplash.extensions.inflate
import com.sergio.unsplash.extensions.load
import com.sergio.unsplash.extensions.startSaturationAnimation
import kotlinx.android.synthetic.main.row_home.view.*
import javax.inject.Inject


class HomeAdapter @Inject constructor() : RecyclerView.Adapter<HomeAdapter.PhotoViewHolder>() {

    private var photoList: MutableList<HomeView> = arrayListOf()

    internal var clickListener: (HomeView, ImageView) -> Unit = { _, _ -> }

    fun addContent(list: List<HomeView>?) {
        list?.let {
            photoList.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            PhotoViewHolder(parent.inflate(R.layout.row_home))

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) =
            holder.bind(photoList[position], clickListener)

    override fun getItemCount() = photoList.size

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(homeView: HomeView, clickListener: (HomeView, ImageView) -> Unit) {
            itemView.mainPictureImageView.load(homeView.mainPhotoUrl, homeView.thumb, onLoadingFinished = {
                itemView.mainPictureImageView.startSaturationAnimation()
            })
            itemView.fullNameTextView.text = homeView.name
            itemView.setOnClickListener { clickListener(homeView, itemView.mainPictureImageView) }
        }
    }
}
