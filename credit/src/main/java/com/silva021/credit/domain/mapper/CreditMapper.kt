package com.silva021.credit.domain.mapper

import com.silva021.credit.data.model.CreditCardResponse
import com.silva021.credit.domain.model.CreditCard
import org.mapstruct.Mapper

@Mapper
interface CreditMapper {
    fun responseToModel(creditCardResponse: CreditCardResponse) : CreditCard
}