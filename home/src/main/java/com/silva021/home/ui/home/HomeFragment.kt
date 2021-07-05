package com.silva021.home.ui.home

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.silva021.home.databinding.FragmentHomeBinding
import com.silva021.home.ui.home.adapter.HomeAdapter
import com.silva021.home.ui.home.adapter.listener.HomeAdapterClick
import com.silva021.network.response.model.Widget
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by sharedViewModel()
    private lateinit var adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.getHomeWidgets()
        setupObserver()
        statementAction
    }

    fun setupAdapter(list: List<Widget>) {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val homeAdapterClick =
            HomeAdapterClick(cardAction = cardAction, statementAction = statementAction)
        binding.recyclerView.adapter = HomeAdapter(list, homeAdapterClick)
    }

    fun setupObserver() {
        viewModel.homeWidget.observe(viewLifecycleOwner, {
            setupAdapter(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    private val cardAction: () -> Unit = {
        navigateNextScreen(Uri.parse("app://CREDIT_SCREEN"))
    }

    private val statementAction: () -> Unit = {
        navigateNextScreen(Uri.parse("app://EXTRACT_SCREEN"))
    }

    private fun navigateNextScreen(uri: Uri) {
        findNavController().navigate(uri)
    }
}