package com.jedun.fretollochallenge.presentation.ui.home.sessionrecycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jedun.fretollochallenge.databinding.ItemExerciseTwoBinding
import com.jedun.fretollochallenge.presentation.model.CompleteExercise

class SessionListAdapter :
    ListAdapter<CompleteExercise, SessionViewHolder>(SessionDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val binding =
            ItemExerciseTwoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SessionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null)
            holder.bind(currentItem)
    }
}

