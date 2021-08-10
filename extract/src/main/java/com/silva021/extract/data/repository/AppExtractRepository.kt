package com.silva021.extract.data.repository

import com.silva021.extract.data.service.ExtractApi
import com.silva021.extract.domain.mapper.ExtractMapper
import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.repository.ExtractRepository
import com.silva021.network.response.Output
import com.silva021.network.response.parseResponse
import java.lang.Exception

class AppExtractRepository(
    private val extractApiService: ExtractApi,
    private val mapper: ExtractMapper,
) : ExtractRepository {
    override suspend fun getTransactions(accountId: String): Output<Extract> {

        return when (val result = extractApiService.getTransactions(accountId).parseResponse()) {
            is Output.Success -> {
                Output.Success(mapper.extractResponseToModel(result.body))
            }
            is Output.Failure -> throw Exception()
        }
    }
}

