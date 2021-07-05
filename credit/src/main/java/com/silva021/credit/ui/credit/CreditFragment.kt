package com.silva021.credit.ui.credit

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.silva021.credit.databinding.FragmentCreditBinding
import com.silva021.credit.domain.model.CreditCard
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CreditFragment : Fragment() {
    private lateinit var binding: FragmentCreditBinding
    private val viewModel: CreditViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
        setupListeners()
        viewModel.loadCardInfo("123")

    }

    private fun setupListeners() {
        binding.imgCardStatus.setOnClickListener {
            findNavController().navigate(Uri.parse("app://EXTRACT_SCREEN"))
        }

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun setupObserver() {
        viewModel.cardCreditInfo.observe(viewLifecycleOwner, {
            when (it) {
                is com.silva021.network.response.Output.Success -> {
                    it.body.let {
                        updateInfoCard(it)
                    }
                }
                is com.silva021.network.response.Output.Failure -> {
                    showErrorLayout()
                }
            }


        })
    }

    private fun showErrorLayout() {
        binding.layoutCard.visibility = View.GONE
        binding.layoutError.visibility = View.VISIBLE
    }

    private fun updateInfoCard(info: CreditCard) {
        binding.shimmerViewContainer.stopShimmer()
        binding.shimmerViewContainer.visibility = View.GONE
        with(info) {
            binding.textCardNumber.text = cardNumber
            binding.textCardHolderName.text = cardName
            binding.textCardDescription.text = "Validade $expirationDate"
            binding.txtLimitAvailable.text = availableLimit
            binding.txtLimitTotal.text = totalLimit
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreditBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

}