package com.silva021.extract.ui.extract

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.silva021.extract.R
import com.silva021.extract.databinding.FragmentExtractBinding
import com.silva021.extract.domain.model.Transaction
import com.silva021.extract.ui.extract.adapter.ExtractItemAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ExtractFragment : Fragment() {
    private var param1: String? = null
    private lateinit var binding: FragmentExtractBinding
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

        binding.recyclerView.adapter = ExtractItemAdapter(
            listOf(
                Transaction(
                    label = "Trasferencia realizada",
                    value = "R$ 150.00",
                    description = "Antonio Batista"
                ),
                Transaction(
                    label = "Pagamento realizado",
                    value = "R$ 4.460.00",
                    description = "MovilePay"
                )
            )
        )
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExtractBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExtractFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}