package com.silva021.credit.domain.usecase

import com.silva021.credit.data.repository.CreditRepository
import com.silva021.credit.domain.model.CreditCard
import java.lang.Exception

interface GetCardInfoUseCase {
    suspend operator fun invoke(): CreditCard
}

class GetCardInfo(private val repository: CreditRepository) : GetCardInfoUseCase {
    override suspend fun invoke(): CreditCard = try {
        repository.getCardInfo()
    } catch (e: Exception) {
        throw e
    }
}
