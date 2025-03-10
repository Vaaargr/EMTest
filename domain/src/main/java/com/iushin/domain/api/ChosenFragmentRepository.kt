package com.iushin.domain.api

import com.iushin.domain.models.Vacancy

interface ChosenFragmentRepository {
    suspend fun getVacancies(): List<Vacancy>
    suspend fun addFavoriteVacancy(vacancy: Vacancy)
    suspend fun deleteFavoriteVacancy(vacancyId: String)
}