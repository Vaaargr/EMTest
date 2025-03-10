package com.iushin.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacancy_table")
data class VacancyEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "vacancy_id")
    val id: String,
    @ColumnInfo(name = "looking_number")
    val lookingNumber: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "town")
    val town: String,
    @ColumnInfo(name = "street")
    val street: String,
    @ColumnInfo(name = "house")
    val house: String,
    @ColumnInfo(name = "company")
    val company: String,
    @ColumnInfo(name = "experience_preview_text")
    val experiencePreviewText: String,
    @ColumnInfo(name = "experience_text")
    val experienceText: String,
    @ColumnInfo(name = "published_date")
    val publishedDate: String,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean,
    @ColumnInfo(name = "salary_short")
    val salaryShort: String?,
    @ColumnInfo(name = "salary_full")
    val salaryFull: String,
    @ColumnInfo(name = "schedules")
    val schedules: String,
    @ColumnInfo(name = "applied_number")
    val appliedNumber: Int?,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "responsibilities")
    val responsibilities: String,
    @ColumnInfo(name = "questions")
    val questions: String
)
