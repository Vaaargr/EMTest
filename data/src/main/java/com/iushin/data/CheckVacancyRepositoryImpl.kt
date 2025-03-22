package com.iushin.data

import com.iushin.data.database.AppDatabase
import com.iushin.domain.api.CheckVacancyRepository

class CheckVacancyRepositoryImpl(private val appDatabase: AppDatabase) : CheckVacancyRepository {
    override suspend fun checkVacancy(vacancyId: String): Boolean {
        return (appDatabase.favoriteVacanciesDAO().checkVacancy(vacancyId) > 0)
    }
}