package com.silva021.credit.data.repository

import com.silva021.credit.data.service.CreditApi
import com.silva021.credit.domain.mapper.CreditMapper
import com.silva021.credit.domain.model.CreditCard
import com.silva021.network.response.Output
import com.silva021.network.response.parseResponse

class AppCreditRepository(private val creditApi: CreditApi, private val mapper: CreditMapper) : CreditRepository {
    override suspend fun getCardInfo(cardId: String): Output<CreditCard> =
        when (val response = creditApi.getCardInfo(cardId = cardId).parseResponse()) {
            is Output.Success -> {
                Output.Success(mapper.responseToModel(response.body))
            }
            is Output.Failure -> {
                throw Exception()
            }
        }
}