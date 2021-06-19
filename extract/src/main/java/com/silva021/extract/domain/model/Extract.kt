package com.silva021.extract.domain.model

import com.squareup.moshi.Json

data class Extract(var balance: Balance, @field:Json(name = "transactions") var transactions: List<Transaction>)