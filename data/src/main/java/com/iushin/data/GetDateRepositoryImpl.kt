package com.iushin.data

import com.iushin.data.network.NetworkClient
import com.iushin.data.network.NetworkMapper
import com.iushin.domain.api.GetDateRepository
import com.iushin.domain.models.Response

class GetDateRepositoryImpl(private val client: NetworkClient, private val mapper: NetworkMapper) :
    GetDateRepository {
    override suspend fun getDate(): Response {
        return mapper.responseDTOToResponseMap(client.getDate())
    }
}