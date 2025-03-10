package com.iushin.domain.models

data class Response(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
)