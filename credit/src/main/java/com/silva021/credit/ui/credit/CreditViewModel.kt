package com.silva021.credit.ui.credit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.credit.domain.model.CreditCard
import com.silva021.credit.domain.usecase.GetCardInfoUseCase
import com.silva021.network.response.Output
import kotlinx.coroutines.launch

class CreditViewModel(private val getCardInfoUseCase: GetCardInfoUseCase) : ViewModel() {
    private val _cardCreditInfo = MutableLiveData<Output<CreditCard>>()
    val cardCreditInfo: LiveData<Output<CreditCard>>
        get() = _cardCreditInfo

    fun loadCardInfo(cardId : String) {
        viewModelScope.launch {
            val info = getCardInfoUseCase(cardId)

            _cardCreditInfo.value = info
        }
    }
}