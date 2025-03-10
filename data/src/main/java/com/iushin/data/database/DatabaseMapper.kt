package com.iushin.data.database

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iushin.data.database.entity.VacancyEntity
import com.iushin.domain.models.Vacancy

class DatabaseMapper(private val gson: Gson) {

    private val type = object : TypeToken<List<String>>() {}.type

    fun mapVacancyToVacancyEntity(vacancy: Vacancy): VacancyEntity {
        return VacancyEntity(
            id = vacancy.id,
            lookingNumber = vacancy.lookingNumber,
            title = vacancy.title,
            town = vacancy.town,
            street = vacancy.street,
            house = vacancy.house,
            company = vacancy.company,
            experiencePreviewText = vacancy.experiencePreviewText,
            experienceText = vacancy.experienceText,
            publishedDate = vacancy.publishedDate,
            isFavorite = vacancy.isFavorite,
            salaryShort = vacancy.salaryShort,
            salaryFull = vacancy.salaryFull,
            schedules = gson.toJson(vacancy.schedules),
            appliedNumber = vacancy.appliedNumber,
            description = vacancy.description,
            responsibilities = vacancy.responsibilities,
            questions = gson.toJson(vacancy.questions)
        )
    }

    fun mapVacancyEntityToVacancy(vacancyEntity: VacancyEntity): Vacancy {
        return Vacancy(
            id = vacancyEntity.id,
            lookingNumber = vacancyEntity.lookingNumber,
            title = vacancyEntity.title,
            town = vacancyEntity.town,
            street = vacancyEntity.street,
            house = vacancyEntity.house,
            company = vacancyEntity.company,
            experiencePreviewText = vacancyEntity.experiencePreviewText,
            experienceText = vacancyEntity.experienceText,
            publishedDate = vacancyEntity.publishedDate,
            isFavorite = vacancyEntity.isFavorite,
            salaryShort = vacancyEntity.salaryShort,
            salaryFull = vacancyEntity.salaryFull,
            schedules = gson.fromJson(vacancyEntity.schedules, type),
            appliedNumber = vacancyEntity.appliedNumber,
            description = vacancyEntity.description,
            responsibilities = vacancyEntity.responsibilities,
            questions = gson.fromJson(vacancyEntity.questions, type)
        )
    }
}