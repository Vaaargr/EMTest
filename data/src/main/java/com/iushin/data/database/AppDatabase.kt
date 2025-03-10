package com.iushin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iushin.data.database.dao.FavoriteVacanciesDAO
import com.iushin.data.database.entity.VacancyEntity

@Database(
    version = 1,
    entities = [VacancyEntity::class],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteVacanciesDAO(): FavoriteVacanciesDAO
}