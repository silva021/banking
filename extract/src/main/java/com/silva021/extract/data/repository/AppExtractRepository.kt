package com.silva021.extract.data.repository

import android.util.Log
import com.silva021.extract.data.service.ExtractApi
import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.repository.ExtractRepository
import com.silva021.network.response.Output
import com.silva021.network.response.parseResponse
import java.lang.Exception

class AppExtractRepository(private val extractApiService: ExtractApi) : ExtractRepository {
    override suspend fun getTransactions(): Extract {
        val extract = extractApiService.getTransactions().parseResponse()

        return when (extract) {
            is Output.Success -> {
                Log.d("Feature-Fragment", "Repository retornou o valor")
                extract.body
            }
            is Output.Failure -> {
                Log.d("Feature-Fragment", "Repository retornou um exception")
                throw Exception()
            }
        }
//        return Extract(Balance("", "", ""), listOf(Transaction("", "", "")))
    }
}


