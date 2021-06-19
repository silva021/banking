package com.silva021.extract.data.service

import com.silva021.extract.domain.model.Extract
import retrofit2.Response
import retrofit2.http.GET

interface ExtractApi {

    @GET("statement/123")
    suspend fun getTransactions(): Response<Extract>
}