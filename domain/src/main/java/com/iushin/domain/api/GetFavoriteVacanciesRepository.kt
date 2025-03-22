package com.iushin.domain.api

import com.iushin.domain.models.Vacancy

interface GetFavoriteVacanciesRepository {
    suspend fun getVacancies(): List<Vacancy>
}