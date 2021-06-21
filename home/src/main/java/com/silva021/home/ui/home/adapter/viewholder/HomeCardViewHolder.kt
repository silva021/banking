package com.silva021.home.ui.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.silva021.home.databinding.WidgetHomeCardBinding
import com.silva021.network.response.model.HomeCardWidget

class HomeCardViewHolder(private val binding: WidgetHomeCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(widget: HomeCardWidget) {
        binding.textCardNumber.text = widget.content.cardNumber
        binding.textSectionTitle.text = widget.content.title
        binding.button.text = widget.content.button.text

        binding.button.setOnClickListener {

        }
    }
}