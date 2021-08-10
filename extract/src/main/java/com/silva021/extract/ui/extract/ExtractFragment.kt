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
import com.silva021.network.response.Output
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
        val accountId = "123"
        viewModel.getTransactions(accountId)
    }

    private fun setupObservers() {
        viewModel.extract.observe(viewLifecycleOwner, {
            when (it) {
                is Output.Success -> {
                    it.body.transactions.let {
                        updateListItemRecyclerView(it)
                        binding.shimmerViewContainer.visibility = View.GONE
                        binding.shimmerViewContainer.stopShimmer()
                    }

                    it.body.balance.let {
                        updateBalance(it)
                    }
                }
                is Output.Failure -> {
                    showErrorLayout()
                }
            }
        })

    }

    private fun showErrorLayout() {
        binding.shimmerViewContainer.visibility = View.GONE
        binding.recyclerView.visibility = View.GONE
        binding.txtLimitTotal.visibility = View.GONE
        binding.txtBalance.visibility = View.GONE
        binding.layoutEmpty.layoutEmpty.visibility = View.VISIBLE
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