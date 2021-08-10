package com.silva021.extract.domain.mapper

import com.silva021.extract.data.model.BalanceResponse
import com.silva021.extract.data.model.ExtractResponse
import com.silva021.extract.data.model.TransactionResponse
import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.model.Transaction
import org.mapstruct.Mapper

@Mapper
interface ExtractMapper {
    fun extractResponseToModel(extractResponse: ExtractResponse): Extract
    fun balanceResponseToModel(balanceResponse: BalanceResponse): BalanceResponse
    fun transactionResponseToModel(transactionResponse: TransactionResponse): Transaction
}