package com.silva021.extract.ui.extract.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.extract.databinding.LayoutItemExtractBinding
import com.silva021.extract.domain.model.Transaction

class ExtractItemAdapter(private val transactions: List<Transaction>) :
    RecyclerView.Adapter<ExtractItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutItemExtractBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(transactions[position])
    }

    override fun getItemCount(): Int = transactions.size

    class ViewHolder(private val binding: LayoutItemExtractBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            binding.txtDescription.text = transaction.description
            binding.txtTypeTransaction.text = transaction.label
            binding.txtValue.text = transaction.value
        }
    }
}