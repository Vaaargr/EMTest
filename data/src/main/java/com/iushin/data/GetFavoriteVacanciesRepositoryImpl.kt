package com.iushin.data

import com.iushin.data.database.AppDatabase
import com.iushin.data.database.DatabaseMapper
import com.iushin.domain.api.GetFavoriteVacanciesRepository
import com.iushin.domain.models.Vacancy

class GetFavoriteVacanciesRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val mapper: DatabaseMapper
) :
    GetFavoriteVacanciesRepository {
    override suspend fun getVacancies(): List<Vacancy> {
        return appDatabase.favoriteVacanciesDAO().getAllFavoriteVacancies()
            .map { mapper.mapVacancyEntityToVacancy(it) }
    }
}