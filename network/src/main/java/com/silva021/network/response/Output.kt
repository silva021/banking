package com.silva021.network.response

import com.silva021.network.response.model.Error
import retrofit2.Response

sealed class Output<out Response> {
    data class Success<Response>(var body: Response) : Output<Response>()
    data class Failure(val errorBody: Error) : Output<Nothing>()
}

fun <R : Any> Response<R>.parseResponse(): Output<R> {
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