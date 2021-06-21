package com.silva021.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.home.domain.usecase.GetHomeWidgetsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getHomeWidgetsUseCase: GetHomeWidgetsUseCase) : ViewModel() {

    fun getHomeWidgets() {
        viewModelScope.launch {
            val homeWidgets = getHomeWidgetsUseCase()
        }
    }
}