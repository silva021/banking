package com.silva021.network.retrofit

import com.silva021.network.config.ConfigApi
import com.silva021.network.response.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInstance {

    private var retrofitBuilder = Retrofit.Builder().baseUrl(ConfigApi.API_URL)
        .client(OkHttpClient.Builder().addInterceptor(interceptor()).build())
        .addConverterFactory(MoshiConverterFactory.create(createProviderMoshi()))
        .build()

    private fun createProviderMoshi(): Moshi {
        return Moshi.Builder().add(createPolymorphicAdapterFactory())
            .add(KotlinJsonAdapterFactory()).build()
    }

    private fun createPolymorphicAdapterFactory() =
        PolymorphicJsonAdapterFactory.of(Widget::class.java, Widget.IDENTIFIER).withDefaultValue(
            Widget("")
        )
            .withSubtype(HomeHeaderWidget::class.java, Widgets.HOME_HEADER_WIDGET.name)
            .withSubtype(HomeCardWidget::class.java, Widgets.HOME_CARD_WIDGET.name)
            .withSubtype(HomeStatementWidget::class.java, Widgets.HOME_STATEMENT_WIDGET.name)

    private fun interceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun <T> createService(apiService: Class<T> ) = retrofitBuilder.create(apiService)
}