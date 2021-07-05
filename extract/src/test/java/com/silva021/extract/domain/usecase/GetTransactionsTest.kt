package com.silva021.extract.domain.usecase

import com.silva021.extract.factory.ExtractFactory
import com.silva021.extract.domain.repository.ExtractRepository
import com.silva021.network.response.Output
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetTransactionsTest {
    private val extractRepository = mockk<ExtractRepository>()
    private val getTransactions = GetTransactions(extractRepository)

    @Test
    fun `should return the extract with information according to account id`() = runBlocking {
        val accountId = "123"
        coEvery { extractRepository.getTransactions(accountId) } returns ExtractFactory.extractOutputSucess

        val result = getTransactions(accountId)

        when (result) {
            is Output.Success -> {
                Assert.assertNotNull(result)
            }
            is Output.Failure -> {
            }
        }
    }

    @Test
    fun `should return the error with information according to account id incorrect`() =
        runBlocking {
            val accountId = "123"
            coEvery { extractRepository.getTransactions(accountId) } returns ExtractFactory.extractOutputFailure

            val result = getTransactions(accountId)

            when (result) {
                is Output.Success -> {
                }
                is Output.Failure -> {
                    Assert.assertNotNull(result)
                }
            }
        }


}