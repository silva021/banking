package com.silva021.credit.domain.usecase

import com.silva021.credit.data.repository.CreditRepository
import com.silva021.credit.domain.model.CreditCard
import com.silva021.network.response.Output
import java.lang.Exception

interface GetCardInfoUseCase {
    suspend operator fun invoke(cardId : String): Output<CreditCard>
}

class GetCardInfo(private val repository: CreditRepository) : GetCardInfoUseCase {
    override suspend fun invoke(cardId : String): Output<CreditCard> = try {
        repository.getCardInfo(cardId)
    } catch (e: Exception) {
        throw e
    }
}
