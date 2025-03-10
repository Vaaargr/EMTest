package com.iushin.domain.api

import com.iushin.domain.models.Response

interface GetDateRepository {
    suspend fun getDate(): Response
}