package com.silva021.credit.data.service

import com.silva021.credit.domain.model.CreditCard
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CreditApi {
    @GET("card/{cardId}")
    suspend fun getCardInfo(@Path("cardId") cardId: String): Response<CreditCard>
}