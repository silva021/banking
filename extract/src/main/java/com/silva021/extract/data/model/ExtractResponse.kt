package com.silva021.extract.data.model

import com.squareup.moshi.Json

data class ExtractResponse(
    var balance: BalanceResponse,
    @field:Json(name = "transactions") var transactions: List<TransactionResponse>
)