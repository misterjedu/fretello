package com.jedun.fretollochallenge.presentation.ui.home.sessionrecycleradapter

import androidx.recyclerview.widget.DiffUtil
import com.jedun.fretollochallenge.presentation.model.Session

/**
 * Diff util to help optimize recycler view adapter
 */
class SessionDiffUtil : DiffUtil.ItemCallback<Session>() {
    override fun areItemsTheSame(oldItem: Session, newItem: Session) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Session, newItem: Session) =
        oldItem == newItem
}