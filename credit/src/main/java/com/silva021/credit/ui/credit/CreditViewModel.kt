package com.silva021.credit.ui.credit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.credit.domain.model.CreditCard
import com.silva021.credit.domain.usecase.GetCardInfoUseCase
import kotlinx.coroutines.launch

class CreditViewModel(private val getCardInfoUseCase: GetCardInfoUseCase) : ViewModel() {
    private val _cardCreditInfo = MutableLiveData<CreditCard>()
    val cardCreditInfo: LiveData<CreditCard>
        get() = _cardCreditInfo

    fun loadCardInfo() {
        viewModelScope.launch {
            val info = getCardInfoUseCase()

            _cardCreditInfo.value = info
        }
    }
}