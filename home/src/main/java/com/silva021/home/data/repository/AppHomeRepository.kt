package com.silva021.home.data.repository

import com.silva021.home.data.model.HomeWidget
import com.silva021.home.data.service.HomeApi
import com.silva021.network.response.Output
import com.silva021.network.response.parseResponse
import java.lang.Exception

class AppHomeRepository(private val service: HomeApi) : HomeRepository {
    override suspend fun getHomeWidgets(): HomeWidget {
        val homeWidgets = service.getHomeWidgets().parseResponse()

        return when (homeWidgets) {
            is Output.Success -> {
                homeWidgets.body
            }
            is Output.Failure -> {
                throw Exception()
            }
        }
    }

}

interface HomeRepository {
    suspend fun getHomeWidgets(): HomeWidget
}