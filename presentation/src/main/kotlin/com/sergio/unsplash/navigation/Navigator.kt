package com.sergio.unsplash.navigation

import android.content.Intent
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.sergio.unsplash.feature.details.DetailsActivity
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.app.ActivityOptionsCompat


@Singleton
class Navigator
@Inject constructor() {

    fun showDetailScreen(
        activity: FragmentActivity,
        photoId: String,
        imageView: ImageView
    ) {
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra(EXTRA_PHOTO_ID, photoId)
        val activityOptions = ActivityOptionsCompat
            .makeSceneTransitionAnimation(activity, imageView, imageView.transitionName)
        activity.startActivity(intent, activityOptions.toBundle())
    }

    companion object {
        const val EXTRA_PHOTO_ID = "EXTRA_PHOTO_ID"
    }
}
