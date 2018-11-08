package com.sergio.unsplash.navigation

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.sergio.unsplash.feature.details.DetailsActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor() {

    fun showDetailScreen(activity: FragmentActivity, photoId: String) {
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra(EXTRA_PHOTO_ID, photoId)
        activity.startActivity(intent)
    }

    companion object {
        const val EXTRA_PHOTO_ID = "EXTRA_PHOTO_ID"
    }
}
