package com.silva021.extract.di

import com.silva021.extract.data.repository.AppExtractRepository
import com.silva021.extract.data.service.ExtractApi
import com.silva021.extract.domain.repository.ExtractRepository
import com.silva021.extract.domain.usecase.GetTransactions
import com.silva021.extract.domain.usecase.GetTransactionsUseCase
import com.silva021.extract.ui.extract.adapter.ExtractViewModel
import com.silva021.network.retrofit.RetrofitInstance
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitInstance().createService(ExtractApi::class.java) }
    single<ExtractRepository> { AppExtractRepository(extractApiService = get()) }
    single<GetTransactionsUseCase> { GetTransactions(repository = get()) }
    single { ExtractViewModel(getTransactionsUseCase = get()) }
}