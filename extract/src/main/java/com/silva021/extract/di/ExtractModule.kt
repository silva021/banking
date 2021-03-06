package com.silva021.extract.di

import com.silva021.extract.data.repository.AppExtractRepository
import com.silva021.extract.data.service.ExtractApi
import com.silva021.extract.domain.mapper.ExtractMapper
import com.silva021.extract.domain.mapper.ExtractMapperImpl
import com.silva021.extract.domain.repository.ExtractRepository
import com.silva021.extract.domain.usecase.GetTransactions
import com.silva021.extract.domain.usecase.GetTransactionsUseCase
import com.silva021.extract.ui.extract.ExtractViewModel
import com.silva021.network.retrofit.RetrofitInstance
import org.koin.dsl.module

val extractModule = module {
    // Criando o singleton da instancia do service do retorift com base na nossa classe passada
    single { RetrofitInstance().createService(ExtractApi::class.java) }
    single<ExtractRepository> { AppExtractRepository(extractApiService = get(), mapper = get()) }
    single<GetTransactionsUseCase> { GetTransactions(repository = get()) }
    single { ExtractViewModel(getTransactionsUseCase = get()) }
    single<ExtractMapper> { ExtractMapperImpl() }
}