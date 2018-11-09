package com.sergio.unsplash.extensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.Drawable
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.sergio.unsplash.utils.FadeAnimator


fun ImageView.load(url: String, thumb: String, animateSaturation: Boolean = false, onLoadingFinished: () -> Unit = {}) {
    val listener = object : RequestListener<Drawable> {
        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
            onLoadingFinished()
            return false
        }

        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
            onLoadingFinished()
            return false
        }
    }
    val requestOptions = RequestOptions()
        .dontTransform()
        .onlyRetrieveFromCache(true)

    val thumbnailRequest: RequestBuilder<Drawable> = Glide.with(this)
        .load(thumb)
        .apply(requestOptions)

    if (animateSaturation) {
        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        colorFilter = ColorMatrixColorFilter(matrix)
    }

    Glide
        .with(context)
        .load(url)
        .thumbnail(thumbnailRequest)
        .transition(GenericTransitionOptions.with(FadeAnimator()))
        .listener(listener)
        .apply(requestOptions)
        .into(this)

}

fun ImageView.startSaturationAnimation() {
    setHasTransientState(true)
    val matrix = ColorMatrix()
    val saturation = ObjectAnimator.ofFloat(
        matrix, "saturation", 0f, 1f
    )
    saturation.addUpdateListener { colorFilter = ColorMatrixColorFilter(matrix) }
    saturation.duration = 2000
    saturation.interpolator = AnimationUtils.loadInterpolator(
        context,
        android.R.interpolator.fast_out_slow_in
    )
    saturation.addListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            clearColorFilter()
            setHasTransientState(false)
        }
    })
    saturation.start()
}
