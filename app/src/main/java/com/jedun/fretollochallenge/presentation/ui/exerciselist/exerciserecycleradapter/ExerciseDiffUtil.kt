package com.jedun.fretollochallenge.presentation.ui.exerciselist.exerciserecycleradapter

import androidx.recyclerview.widget.DiffUtil
import com.jedun.fretollochallenge.presentation.model.ImageExercise

/**
 * Diff util to help optimize recycler view adapter
 */
class ExerciseDiffUtil : DiffUtil.ItemCallback<ImageExercise>() {
    override fun areItemsTheSame(oldItem: ImageExercise, newItem: ImageExercise) =
        oldItem.exerciseName == newItem.exerciseName

    override fun areContentsTheSame(oldItem: ImageExercise, newItem: ImageExercise) =
        oldItem == newItem
}