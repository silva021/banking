package com.silva021.extract.ui.extract

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.extract.domain.model.Balance
import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.model.Transaction
import com.silva021.extract.domain.usecase.GetTransactionsUseCase
import com.silva021.network.response.Output
import kotlinx.coroutines.launch

class ExtractViewModel(private val getTransactionsUseCase: GetTransactionsUseCase) : ViewModel() {

//    private val _transaction = MutableLiveData<List<Transaction>>()
//    val transaction = _transaction as LiveData<List<Transaction>>
//    private val _balance = MutableLiveData<Balance>()
//    val balance = _balance as LiveData<Balance>

    private val _extract = MutableLiveData<Output<Extract>>()
    val extract = _extract as LiveData<Output<Extract>>


    fun getTransactions(accountId: String) {
        viewModelScope.launch {
            Log.d("Feature-Fragment", "ViewModel foi acionado")
            val extract = getTransactionsUseCase(accountId)

            _extract.value = extract
//            _transaction.value = extract.transactions
//            _balance.value = extract.balance
        }
    }

}