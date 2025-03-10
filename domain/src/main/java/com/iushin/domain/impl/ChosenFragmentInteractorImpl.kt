package com.iushin.domain.impl

import com.iushin.domain.api.ChosenFragmentInteractor
import com.iushin.domain.api.ChosenFragmentRepository
import com.iushin.domain.models.Vacancy

class ChosenFragmentInteractorImpl(private val repository: ChosenFragmentRepository) :
    ChosenFragmentInteractor {
    override suspend fun getVacancies(): List<Vacancy> {
        return repository.getVacancies()
    }

    override suspend fun addFavoriteVacancy(vacancy: Vacancy) {
        repository.addFavoriteVacancy(vacancy)
    }

    override suspend fun deleteFavoriteVacancy(vacancyId: String) {
        repository.deleteFavoriteVacancy(vacancyId)
    }
}