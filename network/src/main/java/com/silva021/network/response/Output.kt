package com.silva021.network.response

import com.google.gson.Gson
import com.silva021.network.response.model.Error
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.http.Body
import java.net.HttpURLConnection

sealed class Output<out Response> {
    data class Success<Response>(var body: Response) : Output<Response>()
    data class Failure(val errorBody: Error) : Output<Nothing>()
}

fun <R : Any> Response<R>.parseResponse(): Output<R> {
    val build = Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(Error::class.java)
    if (isSuccessful) {
        val body = body()

        if (body != null) {
            return Output.Success(body)
        }
    } else {
        return Output.Failure(Error("Serviço indisponível."))

    }
    return Output.Failure(Error("Serviço indisponível."))
}