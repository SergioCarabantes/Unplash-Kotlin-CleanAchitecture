package com.sergio.unsplash.features.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sergio.unsplash.R
import com.sergio.unsplash.extensions.inflate
import com.sergio.unsplash.extensions.load
import kotlinx.android.synthetic.main.row_home.view.*
import javax.inject.Inject


class HomeAdapter @Inject constructor() : RecyclerView.Adapter<HomeAdapter.PhotoViewHolder>() {

    private var photoList: MutableList<HomeView> = arrayListOf()

    var clickListener: (HomeView) -> Unit = { }

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
        fun bind(homeView: HomeView, clickListener: (HomeView) -> Unit) {
            itemView.mainPictureImageView.load(homeView.mainPhotoUrl)
            itemView.fullNameTextView.text = homeView.name
            itemView.setOnClickListener { clickListener(homeView) }
        }
    }
}
