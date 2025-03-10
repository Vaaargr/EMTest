package com.iushin.data.network

import com.iushin.data.network.dto.ResponseDTO
import retrofit2.http.GET

interface RetrofitMockApi {

    @GET("uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun getDates(): ResponseDTO
}