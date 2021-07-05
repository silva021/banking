package com.silva021.credit.data.repository

import com.silva021.credit.data.service.CreditApi
import com.silva021.credit.domain.model.CreditCard
import com.silva021.network.response.Output
import com.silva021.network.response.parseResponse
import java.lang.Exception

class AppCreditRepository(private val creditApi: CreditApi) : CreditRepository {
    override suspend fun getCardInfo(cardId : String): Output<CreditCard> {
        return creditApi.getCardInfo(cardId).parseResponse()
        //        return when (val response = creditApi.getCardInfo().parseResponse()) {
//            is Output.Success -> {
//                response.body
//            }
//            is Output.Failure -> {
//                throw Exception()
//            }
//        }
    }
}