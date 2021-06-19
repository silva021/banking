package com.silva021.extract.ui.extract.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.extract.databinding.LayoutItemExtractBinding
import com.silva021.extract.domain.model.Transaction

class ExtractItemAdapter() :
    RecyclerView.Adapter<ExtractItemAdapter.ViewHolder>() {
    private var mTransactionsList: MutableList<Transaction> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutItemExtractBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding);
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addExtractItem(transactions: List<Transaction>) {
        this.mTransactionsList.clear()
        this.mTransactionsList.addAll(transactions)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mTransactionsList[position])
    }

    override fun getItemCount(): Int = mTransactionsList.size

    class ViewHolder(private val binding: LayoutItemExtractBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            binding.txtDescription.text = transaction.description
            binding.txtTypeTransaction.text = transaction.label
            binding.txtValue.text = transaction.value
        }
    }
}