package com.silva021.extract.domain.repository

import com.silva021.extract.domain.model.Extract

interface ExtractRepository {
    suspend fun getTransactions() : Extract
}