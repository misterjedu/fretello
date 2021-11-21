package com.jedun.fretollochallenge.presentation.ui.exerciselist.sessionrecycleradapter

import androidx.recyclerview.widget.DiffUtil
import com.jedun.fretollochallenge.presentation.model.CompleteExercise

/**
 * Diff util to help optimize recycler view adapter
 */
class SessionDiffUtil : DiffUtil.ItemCallback<CompleteExercise>() {
    override fun areItemsTheSame(oldItem: CompleteExercise, newItem: CompleteExercise) =
        oldItem.sessionName == newItem.sessionName

    override fun areContentsTheSame(oldItem: CompleteExercise, newItem: CompleteExercise) =
        oldItem == newItem
}