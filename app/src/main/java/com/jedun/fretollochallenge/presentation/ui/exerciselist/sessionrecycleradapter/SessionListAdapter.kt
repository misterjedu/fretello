package com.jedun.fretollochallenge.presentation.ui.exerciselist.sessionrecycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jedun.fretollochallenge.databinding.ItemSessionBinding
import com.jedun.fretollochallenge.presentation.model.CompleteExercise

class SessionListAdapter :
    ListAdapter<CompleteExercise, SessionViewHolder>(SessionDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val binding =
            ItemSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SessionViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null)
            holder.bind(currentItem)
    }
}

