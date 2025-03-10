package com.iushin.data.network

import com.iushin.data.network.dto.ResponseDTO

interface NetworkClient {
    suspend fun getDate(): ResponseDTO
}