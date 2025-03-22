package com.iushin.emtest.di

import com.iushin.data.CheckVacancyRepositoryImpl
import com.iushin.data.FavoriteVacancyRepositoryImpl
import com.iushin.data.GetDateRepositoryImpl
import com.iushin.data.GetFavoriteVacanciesRepositoryImpl
import com.iushin.domain.api.CheckVacancyRepository
import com.iushin.domain.api.FavoriteVacancyRepository
import com.iushin.domain.api.GetDateRepository
import com.iushin.domain.api.GetFavoriteVacanciesRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<GetDateRepository> {
        GetDateRepositoryImpl(get(), get())
    }

    single<CheckVacancyRepository> {
        CheckVacancyRepositoryImpl(get())
    }

    single<FavoriteVacancyRepository> {
        FavoriteVacancyRepositoryImpl(get(), get())
    }

    single<GetFavoriteVacanciesRepository> {
        GetFavoriteVacanciesRepositoryImpl(get(), get())
    }
}