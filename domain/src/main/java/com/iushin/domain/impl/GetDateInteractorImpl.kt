package com.iushin.domain.impl

import com.iushin.domain.api.GetDateInteractor
import com.iushin.domain.api.GetDateRepository
import com.iushin.domain.models.Response

class GetDateInteractorImpl(private val repository: GetDateRepository): GetDateInteractor{
    override suspend fun getDate(): Response {
        return repository.getDate()
    }
}