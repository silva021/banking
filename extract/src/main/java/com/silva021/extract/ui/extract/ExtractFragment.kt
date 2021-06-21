package com.silva021.extract.ui.extract

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.silva021.extract.databinding.FragmentExtractBinding
import com.silva021.extract.domain.model.Balance
import com.silva021.extract.domain.model.Transaction
import com.silva021.extract.ui.extract.adapter.ExtractItemAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ExtractFragment : Fragment() {
    private lateinit var binding: FragmentExtractBinding
    private val viewModel: ExtractViewModel by sharedViewModel()
    private lateinit var adapter: ExtractItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configRecyclerView()
        setupObservers()
        setupListeners()
        viewModel.getTransactions()
    }

    private fun setupObservers() {
        viewModel.transaction.observe(viewLifecycleOwner, {
            updateListItemRecyclerView(it)
            binding.shimmerViewContainer.visibility = View.GONE
            binding.shimmerViewContainer.stopShimmer()
        })

        viewModel.balance.observe(viewLifecycleOwner, {
            updateBalance(it)
        })
    }


    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun configRecyclerView() {
        adapter = ExtractItemAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun updateBalance(balance: Balance) {
        binding.txtBalance.text = balance.value
    }

    private fun updateListItemRecyclerView(list: List<Transaction>) {
        adapter.addExtractItem(list)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExtractBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }
}