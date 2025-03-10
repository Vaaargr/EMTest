package com.iushin.domain.api

import com.iushin.domain.models.Response

interface GetDateInteractor {
    suspend fun getDate(): Response
}