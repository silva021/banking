package com.silva021.extract.factory

import com.silva021.extract.domain.model.Balance
import com.silva021.extract.domain.model.Extract
import com.silva021.extract.domain.model.Transaction
import com.silva021.network.response.Output
import com.silva021.network.response.model.Error

object ExtractFactory {
    val extract = Extract(
        Balance("Saldo disponível", "R$ 50.000,00"),
        listOf(
            Transaction("Transferência enviada", "- R$ 500,00", "Teste fulano ciclano"),
            Transaction("Pagamento realizado", "- R$ 1.500,00", "Teste fulano ciclano")
        )
    )

    val extractOutputSucess = Output.Success(extract)

    val extractOutputFailure = Output.Failure(Error("Erro"))

}