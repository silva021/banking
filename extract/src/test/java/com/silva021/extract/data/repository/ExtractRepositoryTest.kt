package com.silva021.extract.data.repository

import com.silva021.extract.data.service.ExtractApi
import com.silva021.extract.factory.ExtractFactory
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response
import java.lang.Exception

class ExtractRepositoryTest {
    private val extractApi: ExtractApi = mockk()
    private val repository = AppExtractRepository(extractApi)

    @Test
    fun `should return success when getTransactions with valid id return Extract`() {
        val accountId = "123"
        coEvery { extractApi.getTransactions(accountId) } returns Response.success(ExtractFactory.extract)

        runBlocking {
            val result = repository.getTransactions(accountId)

            Assert.assertNotNull(result)
        }
    }

    @Test
    fun `should return success when getTransactions with not valid id return Exception`() =
        runBlocking {
            val accountId = "1233"
            val jsonString = "{\"error\":{\"title\":\"Serviço indisponível.\"}}"
            coEvery { extractApi.getTransactions(accountId) } returns Response.error(
                400, ResponseBody.create(
                    MediaType.parse("application/json"), jsonString
                )
            )

            val result = repository.getTransactions(accountId)

            Assert.assertNotNull(result)
        }
}