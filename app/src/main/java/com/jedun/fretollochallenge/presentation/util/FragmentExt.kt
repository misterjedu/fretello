package com.jedun.fretollochallenge.presentation.util

import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import com.jedun.fretollochallenge.R

/**
 * Extension function to help with fragment transition animation
 */
fun Fragment.fragmentSlideInLeftAnimation(): NavOptions.Builder {
    val navBuilder: NavOptions.Builder = NavOptions.Builder()
    navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)
    return navBuilder
}