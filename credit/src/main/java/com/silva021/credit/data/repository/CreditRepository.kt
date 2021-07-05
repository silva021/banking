package com.silva021.credit.data.repository

import com.silva021.credit.domain.model.CreditCard
import com.silva021.network.response.Output

interface CreditRepository {
    suspend fun getCardInfo(cardId : String): Output<CreditCard>
}