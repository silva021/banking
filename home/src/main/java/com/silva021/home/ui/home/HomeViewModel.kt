package com.silva021.home.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.home.domain.usecase.GetHomeWidgetsUseCase
import com.silva021.network.response.model.Widget
import kotlinx.coroutines.launch

class HomeViewModel(private val getHomeWidgetsUseCase: GetHomeWidgetsUseCase) : ViewModel() {

    private val _homeWidgets = MutableLiveData<List<Widget>>()
    val homeWidget = _homeWidgets as LiveData<List<Widget>>

    fun getHomeWidgets() {
        viewModelScope.launch {
            val homeWidgetsUseCase = getHomeWidgetsUseCase()

            _homeWidgets.value = homeWidgetsUseCase.widgets
        }
    }
}