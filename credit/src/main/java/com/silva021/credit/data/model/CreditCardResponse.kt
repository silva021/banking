package com.silva021.credit.data.model

data class CreditCardResponse(
    val cardNumber: String,
    val cardName: String,
    val expirationDate: String,
    val availableLimit: String,
    val totalLimit: String,
)