package io.quee.mvp.template.adapter

import androidx.recyclerview.widget.RecyclerView
import io.quee.mvp.domain.CommentData
import io.quee.mvp.template.databinding.ItemCommentsBinding

/**
 * Created by Ibrahim Al-Tamimi on 3/3/20.
 * Licensed for Quee.io
 */

class CommentsHolder(private val binding: ItemCommentsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun load(commentData: CommentData) {
        binding.commentContent = commentData.body
    }
}