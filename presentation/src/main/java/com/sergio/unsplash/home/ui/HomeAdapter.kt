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


class HomeAdapter @Inject constructor() : RecyclerView.Adapter<HomeAdapter.UserViewHolder>() {

    internal var usersList: List<HomeView> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (HomeView) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            UserViewHolder(parent.inflate(R.layout.row_home))

    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) =
            userViewHolder.bind(usersList[position], clickListener)

    override fun getItemCount() = usersList.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(homeView: HomeView, clickListener: (HomeView) -> Unit) {
            itemView.mainPhoto.load(homeView.mainPhotoUrl)
            itemView.setOnClickListener { clickListener(homeView) }
        }
    }
}
