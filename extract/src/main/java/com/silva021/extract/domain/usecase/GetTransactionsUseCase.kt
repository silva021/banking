package com.silva021.extract.domain.usecase

import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.model.Transaction
import com.silva021.extract.domain.repository.ExtractRepository
import java.lang.Exception

interface GetTransactionsUseCase {
    suspend operator fun invoke(): Extract
}

class GetTransactions(private val repository: ExtractRepository) : GetTransactionsUseCase {
    override suspend fun invoke(): Extract = try {
        repository.getTransactions()
    } catch (e: Exception) {
        throw Exception()
    }


}