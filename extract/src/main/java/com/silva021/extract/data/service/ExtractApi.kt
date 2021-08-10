package com.silva021.extract.data.service

import com.silva021.extract.data.model.ExtractResponse
import com.silva021.extract.domain.model.Extract
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExtractApi {

    @GET("statement/{accountId}")
    suspend fun getTransactions(@Path("accountId") accountId: String): Response<ExtractResponse>
}