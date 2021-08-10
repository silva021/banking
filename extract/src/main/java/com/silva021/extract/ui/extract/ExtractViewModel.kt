package com.silva021.extract.ui.extract

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.usecase.GetTransactionsUseCase
import com.silva021.network.response.Output
import kotlinx.coroutines.launch

class ExtractViewModel(private val getTransactionsUseCase: GetTransactionsUseCase) : ViewModel() {
    private val _extract = MutableLiveData<Output<Extract>>()
    val extract = _extract as LiveData<Output<Extract>>


    fun getTransactions(accountId: String) {
        viewModelScope.launch {
            val extract = getTransactionsUseCase(accountId)

            _extract.value = extract
        }
    }

}