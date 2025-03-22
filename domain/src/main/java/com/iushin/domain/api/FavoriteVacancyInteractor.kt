package com.iushin.domain.api

import com.iushin.domain.models.Vacancy

interface FavoriteVacancyInteractor {
    suspend fun addFavoriteVacancy(vacancy: Vacancy): Int
    suspend fun deleteFavoriteVacancy(vacancyId: String): Int
}