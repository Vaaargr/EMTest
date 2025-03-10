package com.iushin.data.network

import com.iushin.data.network.dto.ResponseDTO
import com.iushin.data.network.dto.offer.OfferDTO
import com.iushin.data.network.dto.vacancie.VacancyDTO
import com.iushin.domain.models.Offer
import com.iushin.domain.models.Response
import com.iushin.domain.models.Vacancy

class NetworkMapper {
    fun responseDTOToResponseMap(responseDTO: ResponseDTO): Response {
        val offers = responseDTO.offers.map { offerDTOToOfferMap(it) }
        val vacancies = responseDTO.vacancies.map { vacancyDTOToVacancyMap(it) }
        return Response(offers, vacancies)
    }

    private fun offerDTOToOfferMap(offerDTO: OfferDTO): Offer {
        return Offer(
            id = offerDTO.id,
            title = offerDTO.title,
            buttonText = offerDTO.button?.text,
            link = offerDTO.link
        )
    }

    private fun vacancyDTOToVacancyMap(vacancyDTO: VacancyDTO): Vacancy {
        return Vacancy(
            id = vacancyDTO.id,
            lookingNumber = vacancyDTO.lookingNumber,
            title = vacancyDTO.title,
            town = vacancyDTO.address.town,
            street = vacancyDTO.address.street,
            house = vacancyDTO.address.house,
            company = vacancyDTO.company,
            experiencePreviewText = vacancyDTO.experience.previewText,
            experienceText = vacancyDTO.experience.text,
            publishedDate = vacancyDTO.publishedDate,
            isFavorite = vacancyDTO.isFavorite,
            salaryShort = vacancyDTO.salary.short,
            salaryFull = vacancyDTO.salary.full,
            schedules = vacancyDTO.schedules,
            appliedNumber = vacancyDTO.appliedNumber,
            description = vacancyDTO.description,
            responsibilities = vacancyDTO.responsibilities,
            questions = vacancyDTO.questions
        )
    }
}