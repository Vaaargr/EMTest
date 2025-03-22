package com.iushin.domain.api

interface CheckVacancyRepository {
    suspend fun checkVacancy(vacancyId: String): Boolean
}