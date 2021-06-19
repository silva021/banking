package com.silva021.extract.ui.extract.adapter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.extract.domain.model.Balance
import com.silva021.extract.domain.model.Transaction
import com.silva021.extract.domain.usecase.GetTransactionsUseCase
import kotlinx.coroutines.launch

class ExtractViewModel(private val getTransactionsUseCase: GetTransactionsUseCase) : ViewModel() {

    private val _transaction = MutableLiveData<List<Transaction>>()
    private val _balance = MutableLiveData<Balance>()
    val transaction = _transaction as LiveData<List<Transaction>>
    val balance = _balance as LiveData<Balance>


    fun getTransactions() {
        viewModelScope.launch {
            Log.d("Feature-Fragment", "ViewModel foi acionado")
            val extract = getTransactionsUseCase()

            _transaction.value = extract.transactions
            _balance.value = extract.balance
        }
    }

}