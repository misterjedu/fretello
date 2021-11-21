package com.jedun.fretollochallenge.presentation.ui.exerciselist.exerciserecycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jedun.fretollochallenge.databinding.ItemExerciseBinding
import com.jedun.fretollochallenge.presentation.model.ImageExercise

class ExerciseListAdapter :
    ListAdapter<ImageExercise, ExerciseViewHolder>(ExerciseDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val binding =
            ItemExerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExerciseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null)
            holder.bind(currentItem)
    }
}

