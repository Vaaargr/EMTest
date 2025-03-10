package com.iushin.domain.impl

import com.iushin.domain.api.SearchFragmentDatabaseInteractor
import com.iushin.domain.api.SearchFragmentDatabaseRepository
import com.iushin.domain.models.Vacancy

class SearchFragmentDatabaseInteractorImpl(private val repository: SearchFragmentDatabaseRepository) :
    SearchFragmentDatabaseInteractor {
    override suspend fun addFavoriteVacancy(vacancy: Vacancy) {
        repository.addFavoriteVacancy(vacancy)
    }

    override suspend fun deleteFavoriteVacancy(vacancyId: String) {
        repository.deleteFavoriteVacancy(vacancyId)
    }

    override suspend fun checkVacancy(vacancyId: String): Boolean {
        return repository.checkVacancy(vacancyId)
    }
}