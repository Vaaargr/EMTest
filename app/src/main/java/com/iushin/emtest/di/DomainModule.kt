package com.iushin.emtest.di

import com.iushin.domain.api.FavoriteVacancyInteractor
import com.iushin.domain.api.GetDateInteractor
import com.iushin.domain.impl.CheckVacancyUseCase
import com.iushin.domain.impl.FavoriteVacancyInteractorImpl
import com.iushin.domain.impl.GetDateInteractorImpl
import com.iushin.domain.impl.GetFavoriteVacanciesUseCase
import org.koin.dsl.module

val domainModule = module {

    single<GetDateInteractor> {
        GetDateInteractorImpl(get())
    }

    single<FavoriteVacancyInteractor> {
        FavoriteVacancyInteractorImpl(get())
    }

    single {
        CheckVacancyUseCase(get())
    }

    single {
        GetFavoriteVacanciesUseCase(get())
    }
}