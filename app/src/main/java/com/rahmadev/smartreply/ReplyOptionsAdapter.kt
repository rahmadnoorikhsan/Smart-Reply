package com.rahmadev.smartreply

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.mlkit.nl.smartreply.SmartReplySuggestion
import com.rahmadev.smartreply.databinding.ItemOptionsSmartreplyBinding

class ReplyOptionsAdapter(
    private val onItemClickCallback: OnItemClickCallback
) : RecyclerView.Adapter<ReplyOptionsAdapter.ViewHolder>() {

    val smartReplyOptions = ArrayList<SmartReplySuggestion>()

    interface OnItemClickCallback {
        fun onOptionClicked(optionText: String)
    }

    inner class ViewHolder(val binding: ItemOptionsSmartreplyBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemOptionsSmartreplyBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReplyOptionsAdapter.ViewHolder, position: Int) {
        val optionText = smartReplyOptions[position].text
        holder.binding.tvSmartReplyOption.text = optionText
        holder.itemView.setOnClickListener { onItemClickCallback.onOptionClicked(optionText) }
    }

    override fun getItemCount(): Int {
        return smartReplyOptions.size
    }

    fun setReplyOptions(smartReplyOptions: List<SmartReplySuggestion>) {
        this.smartReplyOptions.clear()
        this.smartReplyOptions.addAll(smartReplyOptions)
        notifyDataSetChanged()
    }

}