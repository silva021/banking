package com.silva021.home.ui.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.silva021.home.databinding.WidgetHomeStatementBinding
import com.silva021.network.response.model.HomeStatementWidget

class HomeStatementViewHolder(private val binding: WidgetHomeStatementBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(widget: HomeStatementWidget) {
        binding.button.text = widget.content.button.text
        binding.textSectionTitle.text = widget.content.title
        binding.textUsedInLabel.text = widget.content.balance.label
        binding.textUsedInValue.text = widget.content.balance.value

    }
}