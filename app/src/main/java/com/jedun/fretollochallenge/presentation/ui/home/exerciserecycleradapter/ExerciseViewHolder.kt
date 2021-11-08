package com.jedun.fretollochallenge.presentation.ui.home.exerciserecycleradapter

import androidx.recyclerview.widget.RecyclerView
import com.jedun.fretollochallenge.databinding.ItemExerciseBinding
import com.jedun.fretollochallenge.domain.model.Exercise

class ExerciseViewHolder(private val binding: ItemExerciseBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(exercise: Exercise) {
        binding.apply {
            this.exercise = exercise
        }
    }
}