package com.silva021.extract.data.repository

import com.silva021.extract.data.service.ExtractApi
import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.repository.ExtractRepository
import com.silva021.network.response.Output
import com.silva021.network.response.parseResponse

class AppExtractRepository(private val extractApiService: ExtractApi) : ExtractRepository {
    override suspend fun getTransactions(accountId: String): Output<Extract> {
        val extract = extractApiService.getTransactions(accountId).parseResponse()

        return extract
    }
}
