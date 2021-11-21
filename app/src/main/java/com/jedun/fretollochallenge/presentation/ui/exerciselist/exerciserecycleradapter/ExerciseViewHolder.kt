package com.jedun.fretollochallenge.presentation.ui.exerciselist.exerciserecycleradapter

import androidx.recyclerview.widget.RecyclerView
import com.jedun.fretollochallenge.databinding.ItemExerciseBinding
import com.jedun.fretollochallenge.presentation.model.ImageExercise

class ExerciseViewHolder(private val binding: ItemExerciseBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(exercise: ImageExercise) {
        binding.apply {
            this.exercise = exercise
        }
    }
}