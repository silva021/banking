package com.silva021.extract.domain.repository

import com.silva021.extract.domain.model.Extract
import com.silva021.network.response.Output

interface ExtractRepository {
    suspend fun getTransactions(accountId: String): Output<Extract>
}