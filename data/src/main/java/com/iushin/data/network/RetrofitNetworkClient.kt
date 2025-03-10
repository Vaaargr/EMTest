package com.iushin.data.network

import com.iushin.data.network.dto.ResponseDTO

class RetrofitNetworkClient(private val mockApi: RetrofitMockApi): NetworkClient {
    override suspend fun getDate(): ResponseDTO {
        return mockApi.getDates()
    }
}