package com.silva021.extract.domain.usecase

import android.util.Log
import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.repository.ExtractRepository
import com.silva021.network.response.Output
import java.lang.Exception

interface GetTransactionsUseCase {
    suspend operator fun invoke(accountId: String): Output<Extract>
}

class GetTransactions(private val repository: ExtractRepository) : GetTransactionsUseCase {
    override suspend fun invoke(accountId: String): Output<Extract> = try {
        repository.getTransactions(accountId)
    } catch (e: Exception) {
        Log.d("Feature-Extract", e.message.toString())
        throw Exception()
    }
}