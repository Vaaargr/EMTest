package com.iushin.data

import com.iushin.data.database.AppDatabase
import com.iushin.data.database.DatabaseMapper
import com.iushin.domain.api.FavoriteVacancyRepository
import com.iushin.domain.models.Vacancy

class FavoriteVacancyRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val mapper: DatabaseMapper
) :
    FavoriteVacancyRepository {
    override suspend fun addFavoriteVacancy(vacancy: Vacancy): Int {
        appDatabase.favoriteVacanciesDAO().addVacancy(mapper.mapVacancyToVacancyEntity(vacancy))
        return appDatabase.favoriteVacanciesDAO().countVacancies()
    }

    override suspend fun deleteFavoriteVacancy(vacancyId: String): Int {
        appDatabase.favoriteVacanciesDAO().deleteVacancy(vacancyId)
        return appDatabase.favoriteVacanciesDAO().countVacancies()
    }
}