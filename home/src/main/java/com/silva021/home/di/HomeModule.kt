package com.silva021.home.di

import com.silva021.home.data.repository.AppHomeRepository
import com.silva021.home.data.repository.HomeRepository
import com.silva021.home.data.service.HomeApi
import com.silva021.home.domain.usecase.GetHomeWidgets
import com.silva021.home.domain.usecase.GetHomeWidgetsUseCase
import com.silva021.home.ui.home.HomeViewModel
import com.silva021.network.retrofit.RetrofitInstance
import org.koin.dsl.module

val homeModule = module {
    single { RetrofitInstance().createService(HomeApi::class.java) }
    single<HomeRepository> { AppHomeRepository(get()) }
    single<GetHomeWidgetsUseCase> { GetHomeWidgets(get()) }
    single { HomeViewModel(get()) }
}