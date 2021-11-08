package com.jedun.fretollochallenge.presentation.ui.home.sessionrecycleradapter

import androidx.recyclerview.widget.RecyclerView
import com.jedun.fretollochallenge.common.Callback
import com.jedun.fretollochallenge.databinding.ItemExerciseTwoBinding
import com.jedun.fretollochallenge.presentation.model.CompleteExercise

class SessionViewHolder(private val binding: ItemExerciseTwoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(exercise: CompleteExercise) {
        binding.apply {
            this.exercise = exercise
        }
    }
}