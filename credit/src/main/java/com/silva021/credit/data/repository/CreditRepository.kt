package com.silva021.credit.data.repository

import com.silva021.credit.domain.model.CreditCard

interface CreditRepository {
    suspend fun getCardInfo(): CreditCard
}