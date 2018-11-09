package com.sergio.unsplash.utils

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.bumptech.glide.request.transition.ViewPropertyTransition

class FadeAnimator : ViewPropertyTransition.Animator {

    override fun animate(view: View) {
        val animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        animator.duration = 300
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.start()
    }
}
