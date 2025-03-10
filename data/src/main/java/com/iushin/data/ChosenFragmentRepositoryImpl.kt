package com.iushin.data

import com.iushin.data.database.AppDatabase
import com.iushin.data.database.DatabaseMapper
import com.iushin.domain.api.ChosenFragmentRepository
import com.iushin.domain.models.Vacancy

class ChosenFragmentRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val mapper: DatabaseMapper,
    private val prefs: ShPrefsController
) : ChosenFragmentRepository {
    override suspend fun getVacancies(): List<Vacancy> {
        return appDatabase.favoriteVacanciesDAO().getAllFavoriteVacancies()
            .map { mapper.mapVacancyEntityToVacancy(it) }
    }

    override suspend fun addFavoriteVacancy(vacancy: Vacancy) {
        appDatabase.favoriteVacanciesDAO().addVacancy(mapper.mapVacancyToVacancyEntity(vacancy))
        prefs.saveCount(appDatabase.favoriteVacanciesDAO().countVacancies())
    }

    override suspend fun deleteFavoriteVacancy(vacancyId: String) {
        appDatabase.favoriteVacanciesDAO().deleteVacancy(vacancyId)
        prefs.saveCount(appDatabase.favoriteVacanciesDAO().countVacancies())
    }
}