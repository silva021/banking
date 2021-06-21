package com.silva021.home.domain.usecase

import com.silva021.home.data.model.HomeWidget
import com.silva021.home.data.repository.HomeRepository
import java.lang.Exception

interface GetHomeWidgetsUseCase {
    suspend operator fun invoke(): HomeWidget
}

class GetHomeWidgets(private val repository: HomeRepository) : GetHomeWidgetsUseCase {
    override suspend fun invoke(): HomeWidget = try {
        repository.getHomeWidgets()
    } catch (e: Exception) {
        throw e
    }

}