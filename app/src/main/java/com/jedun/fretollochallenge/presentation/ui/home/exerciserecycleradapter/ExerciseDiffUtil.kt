package com.jedun.fretollochallenge.presentation.ui.home.exerciserecycleradapter

import androidx.recyclerview.widget.DiffUtil
import com.jedun.fretollochallenge.domain.model.Exercise

/**
 * Diff util to help optimize recycler view adapter
 */
class ExerciseDiffUtil : DiffUtil.ItemCallback<Exercise>() {
    override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise) =
        oldItem == newItem
}