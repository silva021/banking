package com.silva021.credit.data.service

import com.silva021.credit.domain.model.CreditCard
import retrofit2.Response
import retrofit2.http.GET

interface CreditApi {
    @GET("card/123")
    suspend fun getCardInfo() : Response<CreditCard>
}