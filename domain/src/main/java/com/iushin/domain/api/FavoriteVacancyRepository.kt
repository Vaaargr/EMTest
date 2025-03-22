package com.iushin.domain.api

import com.iushin.domain.models.Vacancy

interface FavoriteVacancyRepository {
    suspend fun addFavoriteVacancy(vacancy: Vacancy): Int
    suspend fun deleteFavoriteVacancy(vacancyId: String): Int
}