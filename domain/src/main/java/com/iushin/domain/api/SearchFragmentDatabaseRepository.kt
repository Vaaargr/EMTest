package com.iushin.domain.api

import com.iushin.domain.models.Vacancy

interface SearchFragmentDatabaseRepository {
    suspend fun addFavoriteVacancy(vacancy: Vacancy)
    suspend fun deleteFavoriteVacancy(vacancyId: String)
    suspend fun checkVacancy(vacancyId: String): Boolean
}