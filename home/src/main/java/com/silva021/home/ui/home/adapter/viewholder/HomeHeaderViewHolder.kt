package com.silva021.home.ui.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.silva021.home.databinding.WidgetHomeHeaderBinding
import com.silva021.network.response.model.HomeHeaderWidget

class HomeHeaderViewHolder(private val binding: WidgetHomeHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(widget: HomeHeaderWidget) {
        binding.textWelcome.text = widget.content.title

        binding.textWelcome.setOnClickListener {

        }
    }
}