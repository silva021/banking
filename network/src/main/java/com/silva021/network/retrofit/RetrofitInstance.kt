package com.silva021.network.retrofit

import com.silva021.network.config.ConfigApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInstance {

    private var retrofitBuilder = Retrofit.Builder().baseUrl(ConfigApi.API_URL)
        .client(OkHttpClient.Builder().addInterceptor(interceptor()).build())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private fun interceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun <T> createService(apiService: Class<T>) = retrofitBuilder.create(apiService)
}