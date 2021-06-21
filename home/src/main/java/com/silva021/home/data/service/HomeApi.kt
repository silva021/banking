package com.silva021.home.data.service

import com.silva021.home.data.model.HomeWidget
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
    @GET("home")
    suspend fun getHomeWidgets(): Response<HomeWidget>
}