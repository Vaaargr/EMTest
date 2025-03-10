package com.iushin.domain.models

data class Vacancy(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val town: String,
    val street: String,
    val house: String,
    val company: String,
    val experiencePreviewText: String,
    val experienceText: String,
    val publishedDate: String,
    var isFavorite: Boolean,
    val salaryShort: String?,
    val salaryFull: String,
    val schedules: List<String>,
    val appliedNumber: Int?,
    val description: String?,
    val responsibilities: String,
    val questions: List<String>
)
