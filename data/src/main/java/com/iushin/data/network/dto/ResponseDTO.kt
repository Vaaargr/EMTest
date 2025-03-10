package com.iushin.data.network.dto

import com.iushin.data.network.dto.offer.OfferDTO
import com.iushin.data.network.dto.vacancie.VacancyDTO

data class ResponseDTO(
    val offers: List<OfferDTO>,
    val vacancies: List<VacancyDTO>
)
