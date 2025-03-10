package com.iushin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iushin.data.database.entity.VacancyEntity

@Dao
interface FavoriteVacanciesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addVacancy(vacancy: VacancyEntity)

    @Query("DELETE FROM vacancy_table WHERE vacancy_id=:vacancyId")
    suspend fun deleteVacancy(vacancyId: String)

    @Query("SELECT * FROM vacancy_table")
    suspend fun getAllFavoriteVacancies(): List<VacancyEntity>

    @Query("SELECT COUNT('vacancy_id') FROM vacancy_table WHERE vacancy_id=:vacancyId")
    suspend fun checkVacancy(vacancyId: String): Int

    @Query("SELECT COUNT('vacancy_id') FROM vacancy_table")
    suspend fun countVacancies(): Int
}