package com.jedun.fretollochallenge.presentation.ui.exerciselist.sessionrecycleradapter

import androidx.recyclerview.widget.RecyclerView
import com.jedun.fretollochallenge.databinding.ItemSessionBinding
import com.jedun.fretollochallenge.presentation.model.CompleteExercise
import com.jedun.fretollochallenge.presentation.ui.exerciselist.exerciserecycleradapter.ExerciseListAdapter

class SessionViewHolder(private val binding: ItemSessionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var exerciseListAdapter: ExerciseListAdapter = ExerciseListAdapter()

    private var exerciseRecyclerView: RecyclerView = binding.itemSessionRecycler

    fun bind(exercise: CompleteExercise) {

        exerciseRecyclerView.adapter = exerciseListAdapter
        binding.apply {
            this.exercise = exercise
        }

        exerciseListAdapter.submitList(exercise.exercise.reversed())

    }
}