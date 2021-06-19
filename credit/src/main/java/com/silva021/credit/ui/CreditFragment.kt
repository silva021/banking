package com.silva021.credit.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.silva021.credit.databinding.FragmentCreditBinding
import com.silva021.credit.domain.model.Card

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreditFragment : Fragment() {
    private lateinit var binding: FragmentCreditBinding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardLucas = Card("•••• •••• •••• 8765", "Lucas Silva Sousa", "09/25", "R$ 3.000,00", "R$ 5.000,00")

        with (cardLucas){
            binding.textCardNumber.text = cardNUmber
            binding.textCardHolderName.text = cardName
            binding.textCardDescription.text = "Validade $expirationDate"
        }


        binding.imgCardStatus.setOnClickListener {
            findNavController().navigate(Uri.parse("app://EXTRACT_SCREEN"))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreditBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}