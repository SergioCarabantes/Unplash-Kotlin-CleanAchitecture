package com.sergio.unsplash.home.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sergio.unsplash.R
import com.sergio.unsplash.extensions.inflate
import com.sergio.unsplash.extensions.load
import kotlinx.android.synthetic.main.row_home.view.*
import javax.inject.Inject
import kotlin.properties.Delegates


class HomeAdapter @Inject constructor() : RecyclerView.Adapter<HomeAdapter.PhotoViewHolder>() {

    internal var photoList: List<HomeView> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    private var clickListener: (HomeView) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            PhotoViewHolder(parent.inflate(R.layout.row_home))

    override fun onBindViewHolder(photoViewHolder: PhotoViewHolder, position: Int) =
            photoViewHolder.bind(photoList[position], clickListener)

    override fun getItemCount() = photoList.size

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(homeView: HomeView, clickListener: (HomeView) -> Unit) {
            itemView.mainPhoto.load(homeView.mainPhotoUrl)
            itemView.setOnClickListener { clickListener(homeView) }
        }
    }
}
