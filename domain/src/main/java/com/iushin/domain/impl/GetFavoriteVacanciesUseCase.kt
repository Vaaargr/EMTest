package com.iushin.domain.impl

import com.iushin.domain.api.GetFavoriteVacanciesRepository
import com.iushin.domain.models.Vacancy

class GetFavoriteVacanciesUseCase(private val repository: GetFavoriteVacanciesRepository) {
    suspend fun getVacancies(): List<Vacancy>{
        return  repository.getVacancies()
    }
}