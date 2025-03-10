package com.iushin.data

import com.iushin.data.database.AppDatabase
import com.iushin.data.database.DatabaseMapper
import com.iushin.domain.api.SearchFragmentDatabaseRepository
import com.iushin.domain.models.Vacancy

class SearchFragmentDatabaseRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val mapper: DatabaseMapper,
    private val prefs: ShPrefsController
) : SearchFragmentDatabaseRepository {
    override suspend fun addFavoriteVacancy(vacancy: Vacancy) {
        appDatabase.favoriteVacanciesDAO().addVacancy(mapper.mapVacancyToVacancyEntity(vacancy))
        prefs.saveCount(appDatabase.favoriteVacanciesDAO().countVacancies())
    }

    override suspend fun deleteFavoriteVacancy(vacancyId: String) {
        appDatabase.favoriteVacanciesDAO().deleteVacancy(vacancyId)
        prefs.saveCount(appDatabase.favoriteVacanciesDAO().countVacancies())
    }

    override suspend fun checkVacancy(vacancyId: String): Boolean {
        return (appDatabase.favoriteVacanciesDAO().checkVacancy(vacancyId) > 0)
    }
}