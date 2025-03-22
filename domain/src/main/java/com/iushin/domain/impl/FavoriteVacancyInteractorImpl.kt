package com.iushin.domain.impl

import com.iushin.domain.api.FavoriteVacancyInteractor
import com.iushin.domain.api.FavoriteVacancyRepository
import com.iushin.domain.models.Vacancy

class FavoriteVacancyInteractorImpl(private  val repository: FavoriteVacancyRepository): FavoriteVacancyInteractor {
    override suspend fun addFavoriteVacancy(vacancy: Vacancy): Int {
        return repository.addFavoriteVacancy(vacancy = vacancy)
    }

    override suspend fun deleteFavoriteVacancy(vacancyId: String): Int {
        return repository.deleteFavoriteVacancy(vacancyId = vacancyId)
    }
}