package io.quee.mvp.template.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.quee.mvp.domain.CommentData
import io.quee.mvp.template.R
import io.quee.mvp.template.databinding.ItemCommentsBinding

/**
 * Created by Ibrahim Al-Tamimi on 3/3/20.
 * Licensed for Quee.io
 */

class CommentsAdapter(private val context: Context) : RecyclerView.Adapter<CommentsHolder>() {
    private val items: MutableList<CommentData> = ArrayList()

    fun addItem(item: CommentData) {
        items.add(item)
        notifyItemChanged(items.size - 1)
    }

    fun updateAll(items: Collection<CommentData>) {
        this.items.clear()
        this.items.addAll(items)
        notifyItemChanged(items.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsHolder {
        val binding: ItemCommentsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_comments,
            parent,
            false
        )
        return CommentsHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CommentsHolder, position: Int) {
        holder.load(items[position])
    }

}