package com.silva021.credit.di

import com.silva021.credit.data.repository.AppCreditRepository
import com.silva021.credit.data.repository.CreditRepository
import com.silva021.credit.data.service.CreditApi
import com.silva021.credit.domain.mapper.CreditMapper
import com.silva021.credit.domain.mapper.CreditMapperImpl
import com.silva021.credit.domain.usecase.GetCardInfo
import com.silva021.credit.domain.usecase.GetCardInfoUseCase
import com.silva021.credit.ui.credit.CreditViewModel
import com.silva021.network.retrofit.RetrofitInstance
import org.koin.dsl.module

val creditModule = module {
    single { RetrofitInstance().createService(CreditApi::class.java) }

    single<CreditRepository> {
        AppCreditRepository(creditApi = get(), mapper = get())
    }
    single<GetCardInfoUseCase> {
        GetCardInfo(repository = get())
    }
    single { CreditViewModel(getCardInfoUseCase = get()) }

    single<CreditMapper> { CreditMapperImpl() }
}