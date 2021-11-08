package com.jedun.fretollochallenge.presentation.ui.home.sessionrecycleradapter

import androidx.recyclerview.widget.RecyclerView
import com.jedun.fretollochallenge.common.Callback
import com.jedun.fretollochallenge.databinding.ItemSessionBinding
import com.jedun.fretollochallenge.presentation.model.Session

class SessionViewHolder(private val binding: ItemSessionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(session: Session, clickListener: Callback<String>) {
        binding.apply {
            root.setOnClickListener {
                clickListener(session.name)
            }
            this.session = session
        }
    }
}