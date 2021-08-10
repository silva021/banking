package com.silva021.extract.domain.usecase

import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.repository.ExtractRepository
import com.silva021.network.response.Output

interface GetTransactionsUseCase {
    suspend operator fun invoke(accountId: String): Output<Extract>
}

class GetTransactions(
    private val repository: ExtractRepository
) : GetTransactionsUseCase {
    override suspend fun invoke(accountId: String): Output<Extract> =
        repository.getTransactions(accountId)
}