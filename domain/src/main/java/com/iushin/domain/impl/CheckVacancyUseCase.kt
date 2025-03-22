package com.iushin.domain.impl

import com.iushin.domain.api.CheckVacancyRepository

class CheckVacancyUseCase(private val repository: CheckVacancyRepository) {
    suspend fun checkVacancy(vacancyId: String): Boolean{
        return repository.checkVacancy(vacancyId = vacancyId)
    }
}